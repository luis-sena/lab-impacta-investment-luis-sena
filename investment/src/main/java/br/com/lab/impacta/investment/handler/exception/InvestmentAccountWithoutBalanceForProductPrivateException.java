package br.com.lab.impacta.investment.handler.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class InvestmentAccountWithoutBalanceForProductPrivateException extends RuntimeException {

    private String description;

    public InvestmentAccountWithoutBalanceForProductPrivateException(String message, String description) {
        super(message);
        this.description = description;
    }
}
