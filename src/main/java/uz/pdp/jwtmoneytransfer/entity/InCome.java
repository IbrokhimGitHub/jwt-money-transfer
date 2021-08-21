package uz.pdp.jwtmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class InCome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Card fromCard;
//    private String fromCardNumber;

//    private Integer toCardId;
    @ManyToOne
    private Card toCard;
    private Double amount;
    private Date date;

    public InCome(Card fromCard, Card toCard, Double amount, Date date) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
        this.date = date;
    }
}
