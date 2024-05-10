package br.shop.style.mspayment.controller;

import br.shop.style.mspayment.dto.request.PaymentRequestDto;
import br.shop.style.mspayment.dto.response.PaymentResponseDto;
import br.shop.style.mspayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("v1/payments")
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentResponseDto>> getPayments() {
        var response = paymentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PaymentResponseDto> savePayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        var response = paymentService.create(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> updatePayment(@RequestBody PaymentRequestDto paymentRequestDto,
                                                            @PathVariable Long id) {
        var response = paymentService.update(paymentRequestDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}