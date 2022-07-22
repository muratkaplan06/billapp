package com.muratkaplan.billapp.payment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){this.paymentRepository=paymentRepository;}
    public List<Payment> getPayment(){
        return paymentRepository.findAll();
    }
    //ekleme
    public void addPayment(List<Payment> payments) {
        paymentRepository.saveAll(payments);
    }

    public void deletePayment(int id) {
        boolean exist=paymentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException(id+" does not exist");
        }
        paymentRepository.deleteById(id);
    }


}
