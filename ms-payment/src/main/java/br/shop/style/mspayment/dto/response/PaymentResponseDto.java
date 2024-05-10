package br.shop.style.mspayment.dto.response;

public record PaymentResponseDto(Long id, String type, Boolean installments, Boolean active) {
}