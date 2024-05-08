package br.shop.style.mscustomer.helpers;

import br.shop.style.mscustomer.dto.CustomerDto;
import br.shop.style.mscustomer.entity.Customer;

public class ResponseHelper {
  public static Customer mapToCustomer(CustomerDto customerDto) {
    return Customer.builder()
      .cpf(customerDto.getCpf())
      .firstName(customerDto.getFirstName())
      .lastName(customerDto.getLastName())
      .sex(customerDto.getSex())
      .birthDate(customerDto.getBirthDate())
      .email(customerDto.getEmail())
      .password(customerDto.getPassword())
      .active(customerDto.getActive())
      .build();
  }
}
