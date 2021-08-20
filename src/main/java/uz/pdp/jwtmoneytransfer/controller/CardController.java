package uz.pdp.jwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.jwtmoneytransfer.entity.Card;
import uz.pdp.jwtmoneytransfer.service.CardService;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    CardService cardService;
    @GetMapping()
    public HttpEntity<?> getCard(){
        Card card = cardService.getCard();
        return ResponseEntity.ok(card);
    }
    @PostMapping
    public HttpEntity<?> addCard(@RequestBody Card card){
        cardService.addCard(card);
        return ResponseEntity.ok(card);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deactivate(@PathVariable Integer id){
        boolean deactivate = cardService.deactivate(id);
        return ResponseEntity.status(deactivate?200:402).body(deactivate);
    }
}

