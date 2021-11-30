package br.com.lab.impacta.investment.service;

import br.com.lab.impacta.investment.model.Investiment;

import java.math.BigDecimal;

public interface InvestimentService {
    Investiment invest(Long productId, Long accountId, BigDecimal valueInvestiment);
}
