package uz.pdp.jwtmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutGoing {
    private Integer id;
    private Integer fromCardId;
    private Integer toCardId;
    private Double amount;
    private Date date;
    private Double commissionAmount;

}
