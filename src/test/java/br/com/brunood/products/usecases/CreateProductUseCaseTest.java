package br.com.brunood.products.usecases;

import br.com.brunood.products.factories.ProductFactoryTest;
import br.com.brunood.products.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
public class CreateProductUseCaseTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    CreateProductUseCase createProductUseCase;

    @Test
    void shouldBeAbleToCreateAProduct() {
        when(productRepository.save(any())).thenReturn(ProductFactoryTest.product());

        var product = createProductUseCase.execute(ProductFactoryTest.validPayload());

        verify(productRepository, times(1)).save(any());
        assertEquals("Test category", product.getCategory());
        assertEquals("Test name", product.getDisplayName());
    }
}
