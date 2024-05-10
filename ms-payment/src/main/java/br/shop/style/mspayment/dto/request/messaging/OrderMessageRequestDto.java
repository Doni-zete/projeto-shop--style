package br.shop.style.mspayment.dto.request.messaging;

public record OrderMessageRequestDto(String orderId, PaymentMessageRequestDto payment) {
}
