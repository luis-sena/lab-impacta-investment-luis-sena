package br.com.lab.impacta.investment.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvestimentResponse {
    private Long id;
    private BigDecimal value;
    private LocalDateTime date;
}
