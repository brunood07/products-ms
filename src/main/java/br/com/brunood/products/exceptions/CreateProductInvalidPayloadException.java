package br.com.brunood.products.exceptions;

public class CreateProductInvalidPayloadException extends RuntimeException {
    public CreateProductInvalidPayloadException() {
        super("invalid payload");
    }
}
