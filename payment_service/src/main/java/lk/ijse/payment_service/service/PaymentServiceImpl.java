package lk.ijse.payment_service.service;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.entity.Payment;
import lk.ijse.payment_service.entity.Ticket;
import lk.ijse.payment_service.entity.Vehicle;
import lk.ijse.payment_service.repo.PaymentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {


        return mapper.map(paymentRepo.save(mapper.map(paymentDTO, Payment.class)),PaymentDTO.class);
    }
}
