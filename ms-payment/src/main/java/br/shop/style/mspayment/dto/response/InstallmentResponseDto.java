package br.shop.style.mspayment.dto.response;

import lombok.Data;

@Data
public class InstallmentResponseDto {
    private Long id;
    private Integer amount;
    private String brand;
    private Long paymentId;
}
