package br.com.brunood.products.usecases;

import br.com.brunood.products.repositories.ProductImagesRepository;
import br.com.brunood.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImagesRepository productImagesRepository;

    public void execute(Long productId) {
        this.productRepository.deleteById(productId);
        var images = this.productImagesRepository.findByProductId(productId);

        images.forEach(image -> {
           this.productImagesRepository.deleteById(image.getProductImageId());
        });
    }
}
