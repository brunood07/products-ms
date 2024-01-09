package br.com.brunood.products.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GetProductByIdUseCaseResponseDTO {

    private Long productId;
    private String displayName;
    private BigDecimal salePrice;
    private BigDecimal listPrice;
    private String category;
    private double width;
    private double weight;
    private double height;
    private List<ImageDTO> productImages;
}
