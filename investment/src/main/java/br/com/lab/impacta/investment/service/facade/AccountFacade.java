package br.com.lab.impacta.investment.service.facade;

import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;

import java.math.BigDecimal;

public interface AccountFacade {
    AccountBalanceVO getAccountBalanceById(Long accountID);

    boolean debitAccount(Long accountId, BigDecimal valueInvestiment);
}
