package br.com.lab.impacta.investment.handler.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class InvestmentAccountNotDebitException extends RuntimeException {

    private String description;

    public InvestmentAccountNotDebitException(String message, String description) {
        super(message);
        this.description = description;
    }
}
