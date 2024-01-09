package br.com.brunood.products.usecases;

import br.com.brunood.products.dtos.CreateProductUseCaseRequestDTO;
import br.com.brunood.products.entities.Product;
import br.com.brunood.products.exceptions.CreateProductInvalidPayloadException;
import br.com.brunood.products.repositories.ProductRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    public Product execute(CreateProductUseCaseRequestDTO data) {
        if (ObjectUtils.isEmpty(data)) throw new CreateProductInvalidPayloadException();

        var product = Product.builder()
                .category(data.getCategory())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .displayName(data.getDisplayName())
                .height(data.getHeight())
                .listPrice(data.getListPrice())
                .salePrice(data.getSalePrice())
                .weight(data.getWeight())
                .width(data.getWidth())
                .build();

        return this.productRepository.save(product);
    }
}
