package lk.ijse.vehicle_service.entity;

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
    private String u_id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "u_id")
    private List<Vehicle> vehicles;
}
