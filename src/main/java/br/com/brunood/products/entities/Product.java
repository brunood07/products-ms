package br.com.brunood.products.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "tb_product")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    private String category;
    private double width;
    private double weight;
    private double height;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
