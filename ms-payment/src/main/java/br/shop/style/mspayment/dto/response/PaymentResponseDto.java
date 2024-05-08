package br.shop.style.mspayment.dto.response;

import lombok.Data;

@Data
public class PaymentResponseDto {

    private Long id;
    private String type;
    private Boolean installments;
    private Boolean active;
}