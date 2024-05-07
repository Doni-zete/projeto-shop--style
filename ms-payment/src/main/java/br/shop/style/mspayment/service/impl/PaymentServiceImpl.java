package br.shop.style.mspayment.service.impl;

import br.shop.style.mspayment.entity.Payment;
import br.shop.style.mspayment.repository.PaymentRepository;
import br.shop.style.mspayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void delete(String id) {
        paymentRepository.deleteById(id);
    }
}
