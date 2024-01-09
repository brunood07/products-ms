package br.com.brunood.products.controllers;

import br.com.brunood.products.dtos.CreateProductUseCaseRequestDTO;
import br.com.brunood.products.usecases.CreateProductUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/product")
public class CreateProductController {

    @Autowired
    private CreateProductUseCase createProductUseCase;

    @PostMapping
    public ResponseEntity<Object> createProduct(@Valid @RequestBody CreateProductUseCaseRequestDTO data, UriComponentsBuilder uriBuilder) {
        try {
            var product = this.createProductUseCase.execute(data);
            var uri = uriBuilder.path("/api/v1/product/{id}").buildAndExpand(product.getProductId()).toUri();
            return ResponseEntity.created(uri).body(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
