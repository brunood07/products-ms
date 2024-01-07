package br.com.brunood.products.controllers;

import br.com.brunood.products.usecases.GetProductByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class GetProductByIdController {

    @Autowired
    private GetProductByIdUseCase getProductByIdUseCase;

    @GetMapping("/{productId}")
    public ResponseEntity<Object> getProduct(@PathVariable("productId") Long productId) {
        try {
            return ResponseEntity.ok().body(getProductByIdUseCase.execute(productId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
