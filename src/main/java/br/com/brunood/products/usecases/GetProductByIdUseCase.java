package br.com.brunood.products.usecases;

import br.com.brunood.products.dtos.GetProductByIdUseCaseResponseDTO;
import br.com.brunood.products.dtos.ImageDTO;
import br.com.brunood.products.exceptions.ProductNotFoundException;
import br.com.brunood.products.repositories.ProductImagesRepository;
import br.com.brunood.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProductByIdUseCase {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImagesRepository productImagesRepository;

    public GetProductByIdUseCaseResponseDTO execute(Long productId) {
        var product = this.productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        var images = this.productImagesRepository.findByProductId(productId);

        List<ImageDTO> imagesList = new ArrayList<>();
        images.forEach(image -> {
            imagesList.add(ImageDTO.builder().url("/api/v1/product/images/" + image.getImageHash()).build());
        });

        return GetProductByIdUseCaseResponseDTO.builder()
                .category(product.getCategory())
                .displayName(product.getDisplayName())
                .height(product.getHeight())
                .listPrice(product.getListPrice())
                .productId(productId)
                .productImages(imagesList)
                .salePrice(product.getSalePrice())
                .weight(product.getWeight())
                .width(product.getWidth())
                .build();
    }
}
