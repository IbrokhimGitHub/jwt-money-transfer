package uz.pdp.jwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jwtmoneytransfer.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer,Integer> {
}
