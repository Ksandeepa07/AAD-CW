package lk.ijse.ticket_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id

    private int p_id;
    private Date paymentDate;
    private int payment;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User u_id;

    @OneToOne
    @JoinColumn(name = "t_id")
    private Ticket t_id;

    @OneToOne
    @JoinColumn(name = "v_id")
    private Vehicle v_id;


}
