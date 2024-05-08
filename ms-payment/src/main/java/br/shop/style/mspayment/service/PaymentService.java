package br.shop.style.mspayment.service;

import br.shop.style.mspayment.dto.request.PaymentRequestDto;
import br.shop.style.mspayment.dto.response.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    List<PaymentResponseDto> findAll();

    PaymentResponseDto create(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto update(PaymentRequestDto paymentRequestDto, Long id);

    void delete(Long id);
}