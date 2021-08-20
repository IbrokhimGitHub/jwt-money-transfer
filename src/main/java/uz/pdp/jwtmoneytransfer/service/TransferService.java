package uz.pdp.jwtmoneytransfer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import uz.pdp.jwtmoneytransfer.entity.Card;
import uz.pdp.jwtmoneytransfer.entity.InCome;
import uz.pdp.jwtmoneytransfer.entity.OutGoing;
import uz.pdp.jwtmoneytransfer.entity.Transfer;
import uz.pdp.jwtmoneytransfer.repository.CardRepository;
import uz.pdp.jwtmoneytransfer.repository.TransferRepository;
import uz.pdp.jwtmoneytransfer.securtity.JwtProvider;

import java.sql.Date;


@Service
public class TransferService {
    @Autowired
    CardService cardService;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    IncomingService incomingService;
    @Autowired
    OutGoingService outGoingService;

private static double transferCommission =0.01;
    public boolean doTransfer(Transfer transfer) {
        Card outGoingCard = cardService.getCard(transfer.getOutGoingCardNumber());
        Card inComingCard = cardService.getCard(transfer.getInComingCardNumber());

//        Card inComingCard = cardRepository.findByCardNumber(transfer.getInComingCardNumber());
//        Card outGoingCard = cardRepository.findByCardNumber(transfer.getOutGoingCardNumber());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getUsername() .equals(outGoingCard.getUsername())){
            if (outGoingCard.getBalance()>(transfer.getTransferAmount()*transferCommission+transfer.getTransferAmount())){
                outGoingCard.setBalance(outGoingCard.getBalance()-(transfer.getTransferAmount()*transferCommission+transfer.getTransferAmount()));
                inComingCard.setBalance(inComingCard.getBalance()+transfer.getTransferAmount());
                cardService.editCard(outGoingCard);
                cardService.editCard(inComingCard);
                transferRepository.save(transfer);
                incomingService.save(new InCome(
                        outGoingCard.getCardNumber(),
                        inComingCard,
                        transfer.getTransferAmount(),
                        new Date(System.currentTimeMillis())
                ));
                outGoingService.save(new OutGoing(
                        outGoingCard,inComingCard.getCardNumber(),transfer.getTransferAmount(),new Date(System.currentTimeMillis()),transfer.getTransferAmount()*transferCommission)
                );
                return true;

            }
        }
            return false;


    }


}
