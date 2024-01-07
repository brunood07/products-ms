package br.com.brunood.products.controllers;

import br.com.brunood.products.usecases.DeleteProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class DeleteProductController {

    @Autowired
    private DeleteProductUseCase deleteProductUseCase;

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "productId") Long productId) {
        this.deleteProductUseCase.execute(productId);

        return ResponseEntity.ok().body("product deleted");
    }

}
