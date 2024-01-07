package br.com.brunood.products.dtos;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UpdateProductInfoUseCaseRequestDTO {

    private BigDecimal salePrice;
    private BigDecimal listPrice;
    private String category;
}
