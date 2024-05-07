package br.shop.style.mspayment.repository;

import br.shop.style.mspayment.entity.Installment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends CrudRepository<Installment, Integer> {
}
