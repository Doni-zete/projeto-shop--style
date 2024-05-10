package br.shop.style.mscustomer.service.impl;

import br.shop.style.mscustomer.entity.Customer;
import br.shop.style.mscustomer.repository.CustomerRepository;
import br.shop.style.mscustomer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository repository;

  public Customer save(Customer customer) {
    return repository.save(customer);
  }

  public List<Customer> findAll() {
    return repository.findAll();
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<Customer> findById(Long id) {
    return  repository.findById(id);

  }
}




