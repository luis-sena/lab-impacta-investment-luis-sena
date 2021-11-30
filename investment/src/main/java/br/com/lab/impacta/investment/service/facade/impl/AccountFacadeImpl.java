package br.com.lab.impacta.investment.service.facade.impl;

import br.com.lab.impacta.investment.infrastructure.http.AccountClient;
import br.com.lab.impacta.investment.service.facade.AccountFacade;
import br.com.lab.impacta.investment.service.facade.dto.DebitAccountRequest;
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;
import br.com.lab.impacta.investment.service.facade.valueObject.DebitAccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AccountFacadeImpl implements AccountFacade {

    private final AccountClient client;

    @Override
    public AccountBalanceVO getAccountBalanceById(Long accountID) {
        return client.accountBalance(accountID);
    }

    @Override
    public boolean debitAccount(Long accountId, BigDecimal valueInvestiment) {
        var debitAccountVO = client.debit(accountId, new DebitAccountRequest(valueInvestiment));
        return debitAccountVO.isDebited();
    }
}
