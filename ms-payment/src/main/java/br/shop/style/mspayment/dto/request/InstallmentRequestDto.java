package br.shop.style.mspayment.dto.request;

import lombok.Data;

@Data
public class InstallmentRequestDto {
    private Integer amount;
    private String brand;
    private Long paymentId;
}
