package uz.pdp.jwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.jwtmoneytransfer.entity.InCome;
import uz.pdp.jwtmoneytransfer.repository.InComingRepository;

import java.util.List;

@RestController
@RequestMapping("income")
public class InComeController {
    @Autowired
    InComingRepository inComingRepository;
    @GetMapping("/{cardNumber}")
    public HttpEntity<?> getIncomes(@PathVariable String cardNumber){
        List<InCome> inComeByCardNumber = inComingRepository.getInComeByCardNumber(cardNumber);
        return ResponseEntity.ok(inComeByCardNumber);
    }
}
