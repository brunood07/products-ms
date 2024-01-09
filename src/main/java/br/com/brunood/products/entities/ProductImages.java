package br.com.brunood.products.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tb_product_images")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Long productImageId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "image_hash")
    private String imageHash;

    private String extension;
}
