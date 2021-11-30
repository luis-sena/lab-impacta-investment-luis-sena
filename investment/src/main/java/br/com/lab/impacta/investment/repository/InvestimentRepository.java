package br.com.lab.impacta.investment.repository;

import br.com.lab.impacta.investment.model.Investiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentRepository extends JpaRepository<Investiment, Long> {}
