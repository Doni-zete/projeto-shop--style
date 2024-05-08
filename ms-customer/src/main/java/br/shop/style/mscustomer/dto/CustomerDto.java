package br.shop.style.mscustomer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

  @NotBlank
  private String cpf;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String sex;

  @NotBlank
  private String birthDate;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @Pattern(regexp = "\\d{6}")
  private String password;

  private Boolean active;
}
