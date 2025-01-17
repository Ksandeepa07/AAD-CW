package lk.ijse.payment_service.controller;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.entity.Ticket;
import lk.ijse.payment_service.service.PaymentService;
import lk.ijse.payment_service.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    public PaymentController() {
        System.out.println("payments working!!");
    }

    @PostMapping("/save")
    public PaymentDTO save(@RequestBody PaymentDTO paymentDTO){

        try {
            System.out.println(paymentDTO);
            Boolean isExistUser = restTemplate.getForObject("http://USER-SERVICE/api/v1/users/findById/"+paymentDTO.getU_id(), Boolean.class);
            Boolean isExistVehicle = restTemplate.getForObject("http://VEHICLE-SERVICE/api/v1/vehicles/findById/"+paymentDTO.getV_id(), Boolean.class);
            Boolean isExistTicket = restTemplate.getForObject("http://TICKET-SERVICE/api/v1/tickets/findById/"+paymentDTO.getT_id(), Boolean.class);

            if (Boolean.TRUE.equals(isExistUser) && Boolean.TRUE.equals(isExistVehicle) && Boolean.TRUE.equals(isExistTicket)){
                return paymentService.save(paymentDTO);
            }

        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }

        return null;

    }
}

