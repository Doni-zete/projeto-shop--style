package br.shop.style.mspayment.messaging;

import br.shop.style.mspayment.dto.request.messaging.OrderMessageRequestDto;
import br.shop.style.mspayment.service.impl.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderPaymentConsumer {

    private OrderServiceImpl orderService;

    @RabbitListener(queues = {"order-payment-request"})
    public void processPaymentRequest(OrderMessageRequestDto message){
        orderService.processPayment(message);
    }
}
