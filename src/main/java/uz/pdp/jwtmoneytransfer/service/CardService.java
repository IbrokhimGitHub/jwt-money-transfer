package uz.pdp.jwtmoneytransfer.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import uz.pdp.jwtmoneytransfer.entity.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CardService {
    private  List<Card> cards=new ArrayList<>(
            Arrays.asList(
                    new Card(1,"pdp","123456789",200000.0,new Date(System.currentTimeMillis()+1234567987),true),
                    new Card(2,"cardHolder","987654321",200000.0,new Date(System.currentTimeMillis()+1234567987),true),
                    new Card(3,"uzCard","456123789",200000.0,new Date(System.currentTimeMillis()-123456),true),
                    new Card(4,"pdpCard","789456123",200000.0,new Date(System.currentTimeMillis()+1234567987),false)
            )
    );
    public Card getCard(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (Card card : cards) {
            if (card.getUsername().equals(user.getUsername())){
                return card;
            }
        }
        return new Card();
    }
    public Card getCard(String cardNumber){

        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)){
                return card;
            }
        }
        return new Card();
    }
    public boolean editCard(Card card){
        Integer cardIndex=-1;
        for (Card card1 : cards) {
            cardIndex++;
            if (card1.getId().equals(card.getId())){
                cards.set(cardIndex,card);
                System.out.println(cards);
                return true;
            }
        }
        return false;

    }
    public boolean addCard(Card card){
        return cards.add(card);
    }
    public boolean deactivate(Integer id){
        for (Card card : cards) {
            if (card.getId().equals(id)) {
                card.setActive(false);
                return true;
            }
        }
        return false;
    }
}
