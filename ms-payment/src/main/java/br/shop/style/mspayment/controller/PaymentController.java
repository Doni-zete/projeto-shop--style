package br.shop.style.mspayment.controller;

import br.shop.style.mspayment.entity.Payment;
import br.shop.style.mspayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("v1/payments")
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        var payments = paymentService.findAll();
        return ResponseEntity.ok(payments);
    }

    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        var payments = paymentService.save(payment);
        return ResponseEntity.ok(payments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable String id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}