package lk.ijse.ticket_service.repo;

import lk.ijse.ticket_service.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,String> {
}
