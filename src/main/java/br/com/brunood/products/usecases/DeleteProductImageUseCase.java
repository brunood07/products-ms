package br.com.brunood.products.usecases;

import br.com.brunood.products.exceptions.ProductImageNotFoundException;
import br.com.brunood.products.repositories.ProductImagesRepository;
import br.com.brunood.products.storage.R2Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductImageUseCase {

    @Autowired
    private ProductImagesRepository productImagesRepository;
    @Autowired
    private R2Storage r2Storage;

    public void execute(Long productId, String filename) {
        var image = this.productImagesRepository.findByProductIdAndImageHash(productId, filename).orElseThrow(ProductImageNotFoundException::new);
        this.productImagesRepository.deleteById(image.getProductImageId());
        this.r2Storage.deleteFile(filename);
    }
}
