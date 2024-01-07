package br.com.brunood.products.controllers;

import br.com.brunood.products.usecases.GetProductsByIdsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class GetProductsByIdsController {

    @Autowired
    private GetProductsByIdsUseCase getProductsByIdsUseCase;

    @GetMapping
    public ResponseEntity<Object> getProducts(@RequestParam("ids") String ids) {
        try {
            return ResponseEntity.ok().body(this.getProductsByIdsUseCase.execute(ids));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
