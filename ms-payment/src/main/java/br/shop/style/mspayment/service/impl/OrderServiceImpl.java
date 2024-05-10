package br.shop.style.mspayment.service.impl;

import br.shop.style.mspayment.dto.request.messaging.OrderMessageRequestDto;
import br.shop.style.mspayment.dto.response.messaging.OrderMessageResponseDto;
import br.shop.style.mspayment.enums.ProcessingStatus;
import br.shop.style.mspayment.messaging.OrderPaymentProducer;
import br.shop.style.mspayment.repository.InstallmentRepository;
import br.shop.style.mspayment.repository.PaymentRepository;
import br.shop.style.mspayment.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private InstallmentRepository installmentRepository;
    private PaymentRepository paymentRepository;
    private OrderPaymentProducer orderPaymentProducer;

    public void processPayment(OrderMessageRequestDto orderMessage) {
        var processingStatus = this.getProcessingStatus(orderMessage);

        var response = new OrderMessageResponseDto(orderMessage.orderId(), processingStatus);
        orderPaymentProducer.sendProcessPaymentResponse(response);
    }

    public ProcessingStatus getProcessingStatus(OrderMessageRequestDto orderMessage) {
        var id = orderMessage.payment().id();
        var paymentOptional = paymentRepository.findById(id);

        if (paymentOptional.isEmpty())
            return ProcessingStatus.PAYMENT_NOT_FOUND;

        var payment = paymentOptional.get();

        if (!payment.getActive())
            return ProcessingStatus.PAYMENT_INACTIVE;

        if (!payment.getInstallments())
            return ProcessingStatus.PAYMENT_NOT_INSTALLMENT;

        var installmentOptional = installmentRepository.findByPayment(payment);

        if (installmentOptional.isEmpty())
            return ProcessingStatus.PAYMENT_AMOUNT_NOT_AVAILABLE;

        var installment = installmentOptional.get();

        if (orderMessage.payment().installments() > installment.getAmount())
            return ProcessingStatus.PAYMENT_AMOUNT_NOT_AVAILABLE;

        return ProcessingStatus.PAYMENT_SUCCESSFUL;
    }
}