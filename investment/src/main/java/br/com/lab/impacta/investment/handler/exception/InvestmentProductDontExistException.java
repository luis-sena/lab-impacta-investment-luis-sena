package br.com.lab.impacta.investment.handler.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class InvestmentProductDontExistException extends RuntimeException {

    private String description;

    public InvestmentProductDontExistException(String message, String description) {
        super(message);
        this.description = description;
    }
}
