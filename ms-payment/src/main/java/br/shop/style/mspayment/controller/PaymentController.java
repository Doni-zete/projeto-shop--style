package br.shop.style.mspayment.controller;

import br.shop.style.mspayment.dto.request.PaymentRequestDto;
import br.shop.style.mspayment.dto.response.PaymentResponseDto;
import br.shop.style.mspayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("v1/payments")
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponseDto> getPayments() {
        return paymentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponseDto savePayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        return paymentService.create(paymentRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseDto updatePayment(@RequestBody PaymentRequestDto paymentRequestDto,
                                            @PathVariable Long id) {
        return paymentService.update(paymentRequestDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
    }
}