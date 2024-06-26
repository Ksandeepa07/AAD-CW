package lk.ijse.ticket_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    private String v_id;
    private String brand;
    private String license_plate_num;
    private String capacity;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User u_id;

}
