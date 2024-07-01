package lk.ijse.vehicle_service.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lk.ijse.vehicle_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private int v_id;
    @NotBlank(message = "cannot be null")
    private String brand;
    @NotBlank(message = "cannot be null")
    private String license_plate_num;
    @NotBlank(message = "cannot be null")
    private String capacity;
    private int u_id;
}
