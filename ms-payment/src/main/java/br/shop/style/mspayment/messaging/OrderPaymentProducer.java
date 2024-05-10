package br.shop.style.mspayment.messaging;

import br.shop.style.mspayment.dto.response.messaging.OrderMessageResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderPaymentProducer {

    private RabbitTemplate rabbitTemplate;

    public void sendProcessPaymentResponse(OrderMessageResponseDto response) {
        rabbitTemplate.convertAndSend("order-payment-response", response);
    }

}
