package br.shop.style.mspayment.dto.response.messaging;

import br.shop.style.mspayment.enums.ProcessingStatus;

public record OrderMessageResponseDto(String orderId, ProcessingStatus status) {
}
