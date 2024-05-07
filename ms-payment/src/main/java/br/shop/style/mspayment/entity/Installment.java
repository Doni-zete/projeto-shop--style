package br.shop.style.mspayment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "installments")
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    private String brand;

    @OneToMany
    @JoinColumn(name = "payment_id")
    private List<Payment> payments;
}
