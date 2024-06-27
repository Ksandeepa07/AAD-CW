package lk.ijse.vehicle_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    private int t_id;
    private String route;
    private int price;
    private String distance;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User u_id;

    @OneToOne(mappedBy = "t_id")
    private Payment payment;
}
