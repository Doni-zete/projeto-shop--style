package br.shop.style.mspayment.service.impl;

import br.shop.style.mspayment.dto.request.InstallmentRequestDto;
import br.shop.style.mspayment.dto.response.InstallmentResponseDto;
import br.shop.style.mspayment.exception.InstallmentNotFoundException;
import br.shop.style.mspayment.exception.PaymentMethodNotFoundException;
import br.shop.style.mspayment.mapper.InstallmentMapper;
import br.shop.style.mspayment.repository.InstallmentRepository;
import br.shop.style.mspayment.repository.PaymentRepository;
import br.shop.style.mspayment.service.InstallmentService;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InstallmentServiceImpl implements InstallmentService {

    private PaymentRepository paymentRepository;
    private InstallmentRepository installmentRepository;
    private InstallmentMapper mapper;

    public InstallmentResponseDto update(InstallmentRequestDto installmentRequestDto, Long id) {
        var installment = installmentRepository.findById(id)
                .orElseThrow(() -> new InstallmentNotFoundException("No installment found for id: " + id));

        installment.setAmount(installmentRequestDto.getAmount());
        installment.setBrand(installmentRequestDto.getBrand());

        var updatedInstallment = installmentRepository.save(installment);

        return mapper.installmentToInstallmentResponseDto(updatedInstallment);
    }

    public InstallmentResponseDto create(InstallmentRequestDto installmentRequestDto) {
        var paymentId = installmentRequestDto.getPaymentId();
        var payment = paymentRepository
                .findById(paymentId)
                .orElseThrow(() -> new PaymentMethodNotFoundException("No payment method found for id: " + paymentId));

        if (!payment.getInstallments())
            throw new ValidationException("The payment method with ID " + paymentId + " does not allow installments.");

        var installment = mapper.installmentRequestDtoToInstallment(installmentRequestDto);
        installment.setPayment(payment);
        var savedInstallment = installmentRepository.save(installment);

        return mapper.installmentToInstallmentResponseDto(savedInstallment);
    }

    public void delete(Long id) {
        var payment = installmentRepository.findById(id)
                .orElseThrow(() -> new InstallmentNotFoundException("No payment method found for id: " + id));
        installmentRepository.delete(payment);
    }
}