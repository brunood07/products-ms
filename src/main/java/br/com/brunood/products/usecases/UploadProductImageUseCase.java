package br.com.brunood.products.usecases;

import br.com.brunood.products.entities.ProductImages;
import br.com.brunood.products.repositories.ProductImagesRepository;
import br.com.brunood.products.storage.R2Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class UploadProductImageUseCase {

    @Autowired
    private R2Storage r2Storage;
    @Autowired
    private ProductImagesRepository productImagesRepository;

    public ProductImages execute(Long productId, File file) {
        var filename = UUID.randomUUID().toString();

        this.r2Storage.uploadFile(filename, file);

        var image = ProductImages.builder()
                .extension(file.getName().split("\\.")[1])
                .imageHash(filename)
                .productId(productId)
                .build();

        return this.productImagesRepository.save(image);
    }
}
