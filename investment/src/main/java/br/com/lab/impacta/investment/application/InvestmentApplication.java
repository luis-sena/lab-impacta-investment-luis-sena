package br.com.lab.impacta.investment.application;

import br.com.lab.impacta.investment.application.dto.request.InvestimentRequest;
import br.com.lab.impacta.investment.application.dto.response.InvestimentResponse;

public interface InvestmentApplication {
    InvestimentResponse invest(Long accountId, InvestimentRequest investimentRequest);
}
