package br.com.lab.impacta.investment.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "lab.investment.exceptions")
public class InvestmentExceptionsProperties {
    private String productDontExistsMessage;
    private String productDontExistsDescription;
    private String accountWithoutBalanceMessage;
    private String accountWithoutBalanceDescription;
    private String accountWithoutBalanceForProductPrivateMessage;
    private String accountWithoutBalanceForProductPrivateDescription;
    private String accountIsNotDebitedMessage;
    private String accountIsNotDebitedDescription;
}
