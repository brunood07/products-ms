package br.com.brunood.products.repositories;

import br.com.brunood.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
