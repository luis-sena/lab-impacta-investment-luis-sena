package br.com.lab.impacta.investment.service.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitAccountRequest {
    private BigDecimal valueOfDebit;
}
