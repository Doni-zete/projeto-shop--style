package br.shop.style.mscustomer.entity;

import br.shop.style.mscustomer.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "customers")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cpf;
  private String firstName;
  private String lastName;
  private String sex;
  private String birthDate;
  private String email;
  private String password;
  private Boolean  active;



  public Customer(CustomerDto customerDto) {
    this.cpf = customerDto.getCpf();
    this.firstName = customerDto.getFirstName();
    this.lastName = customerDto.getLastName();
    this.birthDate = customerDto.getBirthDate();
    this.sex = customerDto.getSex();
    this.email = customerDto.getEmail();
    this.password = customerDto.getPassword();
    this.active = customerDto.getActive();

  }
}
