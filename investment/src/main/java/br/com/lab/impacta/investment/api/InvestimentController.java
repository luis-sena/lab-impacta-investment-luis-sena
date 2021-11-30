package br.com.lab.impacta.investment.api;

import br.com.lab.impacta.investment.application.InvestmentApplication;
import br.com.lab.impacta.investment.application.dto.request.InvestimentRequest;
import br.com.lab.impacta.investment.application.dto.response.InvestimentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/account")
public class InvestimentController {

    private final InvestmentApplication investimentApplication;

    @PostMapping("/{accountId}/investiment")
    public ResponseEntity<InvestimentResponse> invest(@PathVariable("accountId") Long accountId,
                                                      @RequestBody InvestimentRequest investimentRequest){

        var investimentResponse = investimentApplication.invest(accountId, investimentRequest);
        return ResponseEntity.ok(investimentResponse);
    }
}
