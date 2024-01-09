package br.com.brunood.products.exceptions;

public class ProductImageNotFoundException extends RuntimeException {
    public ProductImageNotFoundException() {
        super("product image not found");
    }
}
