package lk.ijse.ticket_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private int u_id;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "u_id")
    private List<Vehicle> vehicles;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "u_id")
    private List<Ticket> tickets;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "u_id")
    private List<Payment> payments;
}
