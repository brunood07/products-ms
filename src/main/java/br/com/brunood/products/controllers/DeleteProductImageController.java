package br.com.brunood.products.controllers;

import br.com.brunood.products.usecases.DeleteProductImageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product/images")
public class DeleteProductImageController {

    @Autowired
    private DeleteProductImageUseCase deleteProductImageUseCase;

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteImage(@PathVariable(name = "productId") Long productId, @RequestParam("filename") String filename) {
        this.deleteProductImageUseCase.execute(productId, filename);

        return ResponseEntity.ok().body("deleted");
    }
}
