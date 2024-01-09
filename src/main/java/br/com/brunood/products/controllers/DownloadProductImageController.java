package br.com.brunood.products.controllers;

import br.com.brunood.products.usecases.DownloadProductImageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product/images")
public class DownloadProductImageController {

    @Autowired
    private DownloadProductImageUseCase downloadProductImageUseCase;

    @GetMapping("/{filename}")
    public ResponseEntity<Object> download(@PathVariable(name = "filename") String filename) {
        try {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(this.downloadProductImageUseCase.execute(filename));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
