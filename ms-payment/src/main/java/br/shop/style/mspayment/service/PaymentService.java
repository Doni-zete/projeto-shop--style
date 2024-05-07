package br.shop.style.mspayment.service;

import br.shop.style.mspayment.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();

    Payment save(Payment payment);

    void delete(String payment);
}