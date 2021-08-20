package uz.pdp.jwtmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date transferDate=new Time(System.currentTimeMillis());

    private String outGoingCardNumber;
    private String inComingCardNumber;
    private Double transferAmount;


}
