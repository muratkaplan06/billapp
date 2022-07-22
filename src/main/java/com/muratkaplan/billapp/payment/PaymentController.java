package com.muratkaplan.billapp.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping
    public List<Payment> getPayment(){
        return paymentService.getPayment();
    }
    @PostMapping("/addNewPayment")
    //http://localhost:8080/api/v1/payment/addNewPayment local adrese kaydeder
    public void registerPayment(@RequestBody List<Payment> payments){
        paymentService.addPayment(payments);
    }
    @DeleteMapping(path = "{id}")
    //silme islemi
    public void deletePayment(@PathVariable int id){paymentService.deletePayment(id);}
    //Güncelleme


}
