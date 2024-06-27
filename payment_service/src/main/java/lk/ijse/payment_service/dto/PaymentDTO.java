package lk.ijse.payment_service.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private int p_id;
    private Date paymentDate;
    private int payment;
    private int u_id;
    private int t_id;
    private int v_id;

}
