package br.com.brunood.products.controllers;

import br.com.brunood.products.usecases.UploadProductImageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/api/v1/product/images")
public class UploadProductImageController {

    @Autowired
    private UploadProductImageUseCase uploadProductImageUseCase;

    @PostMapping
    public ResponseEntity<Object> uploadImage(@RequestParam("file")File file, @RequestParam("productId") Long productId) {
        try {
            var image = this.uploadProductImageUseCase.execute(productId, file);
            return ResponseEntity.ok().body(image);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
