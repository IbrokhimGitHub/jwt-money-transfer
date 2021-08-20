package uz.pdp.jwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.jwtmoneytransfer.entity.InCome;

import java.util.List;

public interface InComingRepository extends JpaRepository<InCome,Integer> {
    @Query(value = "select * from in_come ic join Card c on ic.to_card_id=c.id where c.card_number=:cardNumber",nativeQuery = true)

    List<InCome> getInComeByCardNumber(String cardNumber);

}
