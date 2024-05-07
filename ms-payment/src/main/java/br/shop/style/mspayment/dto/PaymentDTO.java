package br.shop.style.mspayment.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    
    private String type;

    private Boolean installments;

    private Boolean active;
}
