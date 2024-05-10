package br.shop.style.mspayment.dto.request;

public record InstallmentRequestDto(Integer amount, String brand, Long paymentId) {
}
