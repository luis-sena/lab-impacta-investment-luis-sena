package br.com.lab.impacta.investment.application.impl;

import br.com.lab.impacta.investment.application.InvestmentApplication;
import br.com.lab.impacta.investment.application.adapter.InvestimentAdapter;
import br.com.lab.impacta.investment.application.dto.request.InvestimentRequest;
import br.com.lab.impacta.investment.application.dto.response.InvestimentResponse;
import br.com.lab.impacta.investment.service.InvestimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvestmentApplicationImpl implements InvestmentApplication {

    private final InvestimentService investimentService;

    @Override
    public InvestimentResponse invest(Long accountId, InvestimentRequest investimentRequest) {
        var investiment = investimentService.invest(investimentRequest.getProductId(),
                accountId, investimentRequest.getValue());

        return InvestimentAdapter.toDtoInvestiment(investiment);
    }
}
