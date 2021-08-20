package uz.pdp.jwtmoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.jwtmoneytransfer.entity.InCome;
import uz.pdp.jwtmoneytransfer.repository.InComingRepository;

@Service
public class IncomingService {
    @Autowired
    InComingRepository inComingRepository;
    public boolean save(InCome inCome){
        inComingRepository.save(inCome);
        return true;
    }
}
