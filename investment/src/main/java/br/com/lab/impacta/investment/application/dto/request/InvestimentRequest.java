package br.com.lab.impacta.investment.application.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvestimentRequest {
    private Long productId;
    private BigDecimal value;
}
