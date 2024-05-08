package br.shop.style.mscustomer.service;

import br.shop.style.mscustomer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

  Customer save(Customer customer);

  List<Customer> findAll();

}
