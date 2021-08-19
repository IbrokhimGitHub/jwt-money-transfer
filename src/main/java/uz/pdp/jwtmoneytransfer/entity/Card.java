package uz.pdp.jwtmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Card {
    private Integer id;
    private User username;
    private Integer cardNumber;
    private Double balance;
    private Date expired_date;
    private boolean active;
}
