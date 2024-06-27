package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.entity.Ticket;
import lk.ijse.ticket_service.repo.TicketRepo;
import lk.ijse.ticket_service.service.exception.DuplicateRecordException;
import lk.ijse.ticket_service.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        if (ticketRepo.existsById((ticketDTO.getT_id()))){
            throw new DuplicateRecordException("this ticket id already exist!!!");
        }
      return mapper.map(ticketRepo.save(mapper.map(ticketDTO,Ticket.class)),TicketDTO.class);
    }

    @Override
    public TicketDTO update(TicketDTO ticketDTO) {
        if (ticketRepo.existsById(ticketDTO.getT_id())){
            return mapper.map(ticketRepo.save(mapper.map(ticketDTO,Ticket.class)),TicketDTO.class);

        }
        throw new NotFoundException("can't find ticket with this id!!");
    }

    @Override
    public boolean delete(int ticketId) {
        if (ticketRepo.existsById(ticketId)){
             ticketRepo.deleteById(ticketId);
             return true;
        }
        throw new NotFoundException("Can't find ticket with this id!!");
    }
}
