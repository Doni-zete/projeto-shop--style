package br.shop.style.mspayment.dto.response;

public record InstallmentResponseDto(Long id, Integer amount, String brand, Long paymentId) {
}
