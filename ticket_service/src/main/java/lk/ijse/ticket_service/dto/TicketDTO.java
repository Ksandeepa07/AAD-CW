package lk.ijse.ticket_service.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lk.ijse.ticket_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private int t_id;
    @NotBlank(message = "cannot be null")
    private String route;
    @Min(value = 1, message = "must be at least 1")
    private int price;
    @NotBlank(message = "cannot be null")
    private String distance;
    private int u_id;
}
