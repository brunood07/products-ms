package br.com.brunood.products.controllers;

import br.com.brunood.products.dtos.UpdateProductInfoUseCaseRequestDTO;
import br.com.brunood.products.usecases.UpdateProductInfoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class UpdateProductInfoController {

    @Autowired
    private UpdateProductInfoUseCase updateProductInfoUseCase;

    @PutMapping("/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable(name = "productId") Long productId, @RequestBody UpdateProductInfoUseCaseRequestDTO data) {
        try {
            this.updateProductInfoUseCase.execute(productId, data);
            return ResponseEntity.ok().body("updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
