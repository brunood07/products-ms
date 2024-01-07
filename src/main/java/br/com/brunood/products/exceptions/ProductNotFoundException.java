package br.com.brunood.products.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("product not found");
    }
}
