package br.com.lab.impacta.investment.repository;

import br.com.lab.impacta.investment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
