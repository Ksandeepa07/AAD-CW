package lk.ijse.vehicle_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    private int v_id;
    private String brand;
    private String license_plate_num;
    private String capacity;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User u_id;

    @OneToOne(mappedBy = "v_id")
    private Payment payment;

}
