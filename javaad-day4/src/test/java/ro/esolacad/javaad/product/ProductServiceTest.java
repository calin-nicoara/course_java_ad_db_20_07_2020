package ro.esolacad.javaad.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StoreProductRepository storeProductRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testSaveProduct() {
        SimpleProductModel inputModel = getTestSimpleProductModel();
        Product expectedProductSaved = getProduct();

        productService.saveProduct(inputModel);

        Mockito.verify(productRepository, times(1)).save(expectedProductSaved);
        Mockito.verifyNoMoreInteractions(productRepository, storeProductRepository);
    }

    private Product getProduct() {
        return Product.builder()
                .brand("MArs")
                .name("Mars bar")
                .price(BigDecimal.valueOf(3.5))
                .build();
    }

    private SimpleProductModel getTestSimpleProductModel() {
        return SimpleProductModel.builder()
                .brand("MArs")
                .name("Mars bar")
                .price(BigDecimal.valueOf(3.5))
                .build();
    }

    @Test
    public void testGetProduct() {
        Product product = Product.builder()
                .id(1L)
                .brand("MArs")
                .name("Mars bar")
                .price(BigDecimal.valueOf(3.5))
                .build();

        Long idForTest = 1L;

        Mockito.when(productRepository.findById(idForTest)).thenReturn(Optional.of(product));
        Mockito.when(storeProductRepository.findByProduct(product)).thenReturn(
                Arrays.asList(StoreProduct.builder().stock(1).storeId(1L).build())
        );

        Optional<ProductModel> productByIdWithOptional = productService.findProductByIdWithOptional(idForTest);

        System.out.println(productByIdWithOptional);

        Mockito.verify(productRepository, times(1)).findById(idForTest);
        Mockito.verify(storeProductRepository, times(1)).findByProduct(product);

        Mockito.verifyNoMoreInteractions(productRepository, storeProductRepository);
    }
}
