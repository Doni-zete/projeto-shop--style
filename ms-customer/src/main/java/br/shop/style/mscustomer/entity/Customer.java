package br.shop.style.mscustomer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "customers")
@Entity(name = "cutomer")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
  private Long id;
  private String cpf;
  private String firstName;
  private String lastName;
  private String sex;
  private String birthdate;
  private String email;
  private String password;
  private boolean ACTIVE;
}
