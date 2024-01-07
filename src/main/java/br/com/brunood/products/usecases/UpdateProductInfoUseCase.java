package br.com.brunood.products.usecases;

import br.com.brunood.products.dtos.UpdateProductInfoUseCaseRequestDTO;
import br.com.brunood.products.exceptions.ProductNotFoundException;
import br.com.brunood.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductInfoUseCase {

    @Autowired
    private ProductRepository productRepository;

    public void execute(Long productId, UpdateProductInfoUseCaseRequestDTO data) {
        var product= this.productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        if (!data.getCategory().isBlank()) product.setCategory(data.getCategory());
        if (data.getListPrice() != null) product.setListPrice(data.getListPrice());
        if (data.getSalePrice() != null) product.setSalePrice(data.getSalePrice());

        this.productRepository.save(product);
    }
}
