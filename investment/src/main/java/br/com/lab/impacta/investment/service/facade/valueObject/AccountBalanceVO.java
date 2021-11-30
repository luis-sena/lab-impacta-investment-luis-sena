package br.com.lab.impacta.investment.service.facade.valueObject;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountBalanceVO {
    private Long accountId;
    private BigDecimal balance;
}
