package br.shop.style.mscustomer.controller;

import br.shop.style.mscustomer.dto.CustomerDto;
import br.shop.style.mscustomer.entity.Customer;
import br.shop.style.mscustomer.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("v1/customers")
public class CustomerController {

  @Autowired
  private CustomerService service;

  @PostMapping
  public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
    service.save(new Customer(customerDto));
    return ResponseEntity.ok(customerDto);
  }

  @GetMapping
  public ResponseEntity<List<Customer>> findAllCustomer() {
    var customer = service.findAll();
    return ResponseEntity.ok(customer);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Customer>> findById(@PathVariable @NotNull Long id) {
    Optional<Customer> customerDto = service.findById(id);
    return ResponseEntity.ok(customerDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable @NotNull Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }




}
