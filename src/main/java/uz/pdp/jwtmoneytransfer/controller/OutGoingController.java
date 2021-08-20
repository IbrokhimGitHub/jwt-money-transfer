package uz.pdp.jwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.jwtmoneytransfer.entity.InCome;
import uz.pdp.jwtmoneytransfer.entity.OutGoing;
import uz.pdp.jwtmoneytransfer.repository.InComingRepository;
import uz.pdp.jwtmoneytransfer.repository.OutgoingRepository;

import java.util.List;

@RestController
@RequestMapping("outgoing")
public class OutGoingController {
    @Autowired
    OutgoingRepository outgoingRepository;
    @GetMapping("/{cardNumber}")
    public HttpEntity<?> getIncomes(@PathVariable String cardNumber){
        List<OutGoing> outGoingByCardNumber = outgoingRepository.getOutGoingByCardNumber(cardNumber);
        return ResponseEntity.ok(outGoingByCardNumber);
    }
}
