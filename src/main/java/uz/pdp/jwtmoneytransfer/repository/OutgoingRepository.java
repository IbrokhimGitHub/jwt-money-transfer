package uz.pdp.jwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.jwtmoneytransfer.entity.Card;
import uz.pdp.jwtmoneytransfer.entity.InCome;
import uz.pdp.jwtmoneytransfer.entity.OutGoing;

import java.util.List;

public interface OutgoingRepository extends JpaRepository<OutGoing,Integer> {
    @Query(value = "select * from out_going ig join Card c on ig.from_card_id=c.id where c.card_number=:cardNumber",nativeQuery = true)

    List<OutGoing> getOutGoingByCardNumber(String cardNumber);
}
