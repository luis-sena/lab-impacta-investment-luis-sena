package br.com.lab.impacta.investment.service.impl;

import br.com.lab.impacta.investment.config.properties.InvestmentExceptionsProperties;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountNotDebitException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceForProductPrivateException;
import br.com.lab.impacta.investment.handler.exception.InvestmentProductDontExistException;
import br.com.lab.impacta.investment.model.Investiment;
import br.com.lab.impacta.investment.model.Product;
import br.com.lab.impacta.investment.repository.InvestimentRepository;
import br.com.lab.impacta.investment.repository.ProductRepository;
import br.com.lab.impacta.investment.service.InvestimentService;
import br.com.lab.impacta.investment.service.facade.AccountFacade;
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvestimentServiceImpl implements InvestimentService {

    private final InvestmentExceptionsProperties messages;
    private final InvestimentRepository investimentRepository;
    private final ProductRepository productRepository;
    private final AccountFacade accountFacade;

    @Override
    public Investiment invest(Long productId, Long accountId, BigDecimal valueInvestiment) {
        var optionalProduct = productRepository.findById(productId);
        var product = optionalProduct.orElseThrow(() ->
                new InvestmentProductDontExistException(messages.getProductDontExistsMessage(),
                        messages.getProductDontExistsDescription()));

        var investiment = new Investiment(product, accountId, valueInvestiment);
        var accountBalanceVO = accountFacade.getAccountBalanceById(accountId);

        if(!investiment.sufficientBalanceForInvestment(accountBalanceVO.getBalance()))
            throw new InvestmentAccountWithoutBalanceException(messages.getAccountWithoutBalanceMessage(),
                    messages.getAccountWithoutBalanceDescription());

        if (!investiment.verifyProductPrivateOrDefaultForInvestiment(accountBalanceVO.getBalance(), product))
                throw new InvestmentAccountWithoutBalanceForProductPrivateException(
                        messages.getAccountWithoutBalanceForProductPrivateMessage(),
                        messages.getAccountWithoutBalanceForProductPrivateDescription());

        var isDebited = accountFacade.debitAccount(accountId, valueInvestiment);

        if(!isDebited)
            throw new InvestmentAccountNotDebitException(messages.getAccountIsNotDebitedMessage(),
                    messages.getAccountIsNotDebitedDescription());

        return investimentRepository.save(investiment);
    }
}
