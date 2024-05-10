package br.shop.style.mspayment.service.impl;

import br.shop.style.mspayment.dto.request.PaymentRequestDto;
import br.shop.style.mspayment.dto.response.PaymentResponseDto;
import br.shop.style.mspayment.exception.PaymentMethodAlreadyExistsException;
import br.shop.style.mspayment.exception.PaymentMethodNotFoundException;
import br.shop.style.mspayment.mapper.PaymentMapper;
import br.shop.style.mspayment.repository.PaymentRepository;
import br.shop.style.mspayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository repository;
    private PaymentMapper mapper;

    @Override
    public List<PaymentResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::paymentToPaymentResponseDto)
                .toList();
    }

    @Override
    public PaymentResponseDto update(PaymentRequestDto paymentRequestDto, Long id) {
        var payment = repository.findById(id)
                .orElseThrow(() -> new PaymentMethodNotFoundException("No payment method found for id: " + id));
        payment.setActive(paymentRequestDto.active());
        payment.setInstallments(paymentRequestDto.installments());
        payment.setType(paymentRequestDto.type());

        var updatedPayment = repository.save(payment);

        return mapper.paymentToPaymentResponseDto(updatedPayment);
    }

    @Override
    public PaymentResponseDto create(PaymentRequestDto paymentRequestDto) {
        repository.findByType(paymentRequestDto.type()).ifPresent(value -> {
            throw new PaymentMethodAlreadyExistsException("The payment method \""
                    + paymentRequestDto.type() + "\" already exists.");
        });
        var payment = mapper.paymentRequestDtoToPayment(paymentRequestDto);
        var savedPayment = repository.save(payment);

        return mapper.paymentToPaymentResponseDto(savedPayment);
    }

    @Override
    public void delete(Long id) {
        var payment = repository.findById(id)
                .orElseThrow(() -> new PaymentMethodNotFoundException("No payment method found for id: " + id));
        repository.delete(payment);
    }
}