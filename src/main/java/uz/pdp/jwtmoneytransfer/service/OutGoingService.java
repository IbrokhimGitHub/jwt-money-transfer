package uz.pdp.jwtmoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.jwtmoneytransfer.entity.OutGoing;
import uz.pdp.jwtmoneytransfer.repository.OutgoingRepository;

@Service
public class OutGoingService {
    @Autowired
    OutgoingRepository outgoingRepository;
    public boolean save(OutGoing outGoing){
        outgoingRepository.save(outGoing);
        return true;

    }
}
