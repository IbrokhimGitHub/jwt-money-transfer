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
public class OutGoing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Card fromCard;


//    private Integer fromCardId;
    private String toCardNumber;
    private Double amount;
    private Date date;
    private Double commissionAmount;

    public OutGoing(Card fromCard, String toCardNumber, Double amount, Date date, Double commissionAmount) {
        this.fromCard = fromCard;
        this.toCardNumber = toCardNumber;
        this.amount = amount;
        this.date = date;
        this.commissionAmount = commissionAmount;
    }
}
