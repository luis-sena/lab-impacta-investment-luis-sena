package br.com.lab.impacta.investment.application.adapter;

import br.com.lab.impacta.investment.application.dto.response.InvestimentResponse;
import br.com.lab.impacta.investment.model.Investiment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvestimentAdapter {

    public static InvestimentResponse toDtoInvestiment(Investiment investiment){
        return InvestimentResponse.builder()
                .id(investiment.getId())
                .value(investiment.getValue())
                .date(investiment.getDate()).build();
    }
}
