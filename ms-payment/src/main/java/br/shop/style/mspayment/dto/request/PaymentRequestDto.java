package br.shop.style.mspayment.dto.request;

public record PaymentRequestDto(String type, Boolean installments, Boolean active) {
}
