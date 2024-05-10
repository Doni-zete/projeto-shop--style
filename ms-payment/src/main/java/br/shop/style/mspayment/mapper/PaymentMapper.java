package br.shop.style.mspayment.mapper;

import br.shop.style.mspayment.dto.request.PaymentRequestDto;
import br.shop.style.mspayment.dto.response.PaymentResponseDto;
import br.shop.style.mspayment.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponseDto paymentToPaymentResponseDto(Payment payment);

    Payment paymentRequestDtoToPayment(PaymentRequestDto paymentResponseDto);
}
