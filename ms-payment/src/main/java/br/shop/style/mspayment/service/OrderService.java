package br.shop.style.mspayment.service;

import br.shop.style.mspayment.dto.request.messaging.OrderMessageRequestDto;
import br.shop.style.mspayment.enums.ProcessingStatus;

public interface OrderService {
    ProcessingStatus getProcessingStatus(OrderMessageRequestDto orderMessage);
}
