package uz.pdp.jwtmoneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.jwtmoneytransfer.entity.Card;
@RepositoryRestResource(path = "card")
public interface CardRepository extends JpaRepository<Card,Integer> {
    Card findByCardNumber(String cardNumber);
}
