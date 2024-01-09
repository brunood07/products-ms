package br.com.brunood.products.repositories;

import br.com.brunood.products.entities.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {

    List<ProductImages> findByProductId(Long productId);
    Optional<ProductImages> findByProductIdAndImageHash(Long productId, String imageHash);
}
