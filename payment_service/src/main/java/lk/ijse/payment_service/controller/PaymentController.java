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
//            System.out.println(paymentDTO);
//            Boolean isExistUser = restTemplate.getForObject("http://USER-SERVICE/api/v1/users/findById/"+paymentDTO.getU_id(), Boolean.class);
//            if (Boolean.TRUE.equals(isExistUser)){
//                return paymentService.save(paymentDTO);
//            }
            return paymentService.save(paymentDTO);

        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }


    }
}

