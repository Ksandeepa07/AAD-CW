package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.dto.TicketDTO;

public interface TicketService {
    TicketDTO save(TicketDTO ticketDTO);
    TicketDTO update(TicketDTO ticketDTO);
    boolean delete(int ticketId);
}
