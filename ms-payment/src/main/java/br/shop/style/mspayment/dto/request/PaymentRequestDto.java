package br.shop.style.mspayment.dto.request;

import lombok.Data;

@Data
public class PaymentRequestDto {
    private String type;
    private Boolean installments;
    private Boolean active;
}
