package br.com.brunood.products.factories;


import br.com.brunood.products.dtos.CreateProductUseCaseRequestDTO;
import br.com.brunood.products.entities.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductFactoryTest {

    public static CreateProductUseCaseRequestDTO validPayload() {

        return CreateProductUseCaseRequestDTO.builder()
                .category("Test category")
                .displayName("Test name")
                .height(1)
                .listPrice(BigDecimal.TEN)
                .salePrice(BigDecimal.ONE)
                .weight(1)
                .width(1)
                .build();
    }

    public static Product product() {

        return Product.builder()
                .category("Test category")
                .displayName("Test name")
                .height(1)
                .listPrice(BigDecimal.TEN)
                .salePrice(BigDecimal.ONE)
                .weight(1)
                .width(1)
                .productId(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
