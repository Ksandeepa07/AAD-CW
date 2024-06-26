package lk.ijse.ticket_service.controller;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.service.TicketService;
import lk.ijse.ticket_service.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.PatchExchange;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RestTemplate restTemplate;

    public TicketController() {
        System.out.println("ticket controller !!");
    }

    @PostMapping("/save")
    public TicketDTO save(@RequestBody TicketDTO ticketDTO){
        try {
            System.out.println(ticketDTO);
            Boolean isExist = restTemplate.postForObject("http://USER-SERVICE/api/v1/users/findById", ticketDTO.getU_id(), Boolean.class);
            if (Boolean.TRUE.equals(isExist)){
                return ticketService.save(ticketDTO);
            }
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

        return null;
    }

    @PatchExchange("/update")
    public TicketDTO update(@RequestBody TicketDTO ticketDTO){
        try {
            System.out.println(ticketDTO);
            Boolean isExist = restTemplate.postForObject("http://USER-SERVICE/api/v1/users/findById", ticketDTO.getU_id(), Boolean.class);
            if (Boolean.TRUE.equals(isExist)){
                return ticketService.update(ticketDTO);
            }
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

        return null;
    }

    @DeleteMapping("/delete/{ticketId}")
    public boolean delete(@PathVariable String ticketId){

        try {
            System.out.println(ticketId);
            return ticketService.delete(ticketId);

        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

    }
}
