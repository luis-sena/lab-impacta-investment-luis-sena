package br.com.lab.impacta.investment.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Investiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private Long accountId;
    private BigDecimal value;

    @CreationTimestamp
    private LocalDateTime date;
    private boolean privateInvestiment;

    public Investiment(Product product, Long accountId, BigDecimal value) {
        this.product = product;
        this.accountId = accountId;
        this.value = value;
        this.privateInvestiment = product.isPrivateInvestment();
    }

    public boolean sufficientBalanceForInvestment(BigDecimal accountBalance) {
        return this.value.compareTo(accountBalance) < 0;
    }

    public boolean verifyProductPrivateOrDefaultForInvestiment(BigDecimal accountBalance, Product product){
        var isMoreThanMinValue = accountBalance.compareTo(product.getMinimumValueForInvestment()) >= 0;
        return !this.privateInvestiment || (this.privateInvestiment && isMoreThanMinValue);
    }
}


/*
        if(!product.isPrivateInvestment()){
            this.privateInvestiment = false;
            return true;
        }

        if(product.isPrivateInvestment() && accountBalance.compareTo(product.getMinumumValueForInvestiment()) >= 0){
            this.privateInvestiment = true;
            return true;
        }
        return false;
 */