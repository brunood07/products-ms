package br.com.brunood.products.usecases;

import br.com.brunood.products.dtos.GetProductByIdUseCaseResponseDTO;
import br.com.brunood.products.dtos.ImageDTO;
import br.com.brunood.products.exceptions.ProductNotFoundException;
import br.com.brunood.products.repositories.ProductImagesRepository;
import br.com.brunood.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GetProductsByIdsUseCase {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImagesRepository productImagesRepository;

    public List<GetProductByIdUseCaseResponseDTO> execute(String productIds) {
        String[] ids = productIds.split(",");

        List<GetProductByIdUseCaseResponseDTO> listOfProducts = new ArrayList<>();

        Arrays.stream(ids).toList().forEach(id -> {
            var productId = Long.valueOf(id);
            var product = this.productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
            var images = this.productImagesRepository.findByProductId(productId);

            List<ImageDTO> imagesList = new ArrayList<>();
            images.forEach(image -> {
                imagesList.add(ImageDTO.builder().url("/api/v1/product/images/" + image.getImageHash()).build());
            });

           listOfProducts.add(GetProductByIdUseCaseResponseDTO.builder()
                   .category(product.getCategory())
                   .displayName(product.getDisplayName())
                   .height(product.getHeight())
                   .listPrice(product.getListPrice())
                   .productId(product.getProductId())
                   .productImages(imagesList)
                   .salePrice(product.getSalePrice())
                   .weight(product.getWeight())
                   .width(product.getWidth())
                   .build());
        });

        return listOfProducts;
    }
}
