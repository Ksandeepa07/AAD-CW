package lk.ijse.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private String v_id;
    private String brand;
    private String license_plate_num;
    private String capacity;
    private String u_id;
}
