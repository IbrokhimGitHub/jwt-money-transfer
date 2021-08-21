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

    @ManyToOne

    private Card toCard;
    private Double amount;
    private Date date;
    private Double commissionAmount;

    public OutGoing(Card fromCard, Card toCard, Double amount, Date date, Double commissionAmount) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
        this.date = date;
        this.commissionAmount = commissionAmount;
    }
}
