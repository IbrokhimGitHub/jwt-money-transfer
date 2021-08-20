package uz.pdp.jwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.jwtmoneytransfer.entity.Transfer;
import uz.pdp.jwtmoneytransfer.service.TransferService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("transfer")
public class TransferController {
    @Autowired
    TransferService transferService;
    @PostMapping
    public HttpEntity<?> doTransfer(@RequestBody Transfer transfer){
        boolean transferCondition = transferService.doTransfer(transfer);
        return ResponseEntity.status(transferCondition?200:401).body(transferCondition)   ;
    }
}
