package br.shop.style.mspayment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "installments")
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer amount;

    private String brand;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
