package br.com.brunood.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateProductUseCaseRequestDTO {

    @NotBlank(message = "displayname must be filled")
    private String displayName;

    private BigDecimal salePrice;

    @NotNull(message = "listprice must be filled")
    private BigDecimal listPrice;

    @NotBlank(message = "category must be filled")
    private String category;

    @NotNull(message = "width must be filled")
    private double width;
    @NotNull(message = "weight must be filled")
    private double weight;
    @NotNull(message = "height must be filled")
    private double height;
}
