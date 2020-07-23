package ro.esolacad.javaad.product;

import org.hibernate.annotations.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
class ProductServiceTestIT {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreProductRepository storeProductRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void testFindAll() {
//        Product productToSave = Product.builder()
//                .id(1L)
//                .name("Ionut")
//                .price(BigDecimal.ONE.setScale(2))
//                .brand("Coca-Cola")
//                .build();
//
//        productRepository.save(productToSave);
//
//        List<Product> allProducts = productService.findAllProducts();
//        assertEquals(1, allProducts.size());
//        assertEquals(productToSave, allProducts.get(0));
//
//        System.out.println(allProducts);
    }

    @Test
    public void testFindById() {
        Product productToSave = Product.builder()
                .id(1L)
                .name("Ionut")
                .price(BigDecimal.ONE.setScale(2))
                .brand("Coca-Cola")
                .build();

        productRepository.save(productToSave);

        Product productById = productService.findProductById(1L);

        assertEquals(productToSave,productById);
    }

    @Test
    public void testSaveProductAndStoreProduct() {
        Product productToSave = Product.builder()
                .name("Ionut")
                .price(BigDecimal.ONE.setScale(2))
                .brand("Coca-Cola")
                .build();

        try {
            productService.saveProductAndStoreProducts(productToSave,
                    Arrays.asList(1L, 2L), 5);
        } catch(RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(productRepository.findAll());
        System.out.println(storeProductRepository.findAll());
    }

    @Test
    @Sql(value = "/sql/add_products.sql")
    @Sql(value = "/sql/delete_all.sql", executionPhase = AFTER_TEST_METHOD)
    public void testUpdateName() {
//        Product productToSave = Product.builder()
//                .name("Ionut")
//                .price(BigDecimal.ONE.setScale(2))
//                .brand("Coca-Cola")
//                .build();
//
//        Product savedProduct = productRepository.save(productToSave);

        System.out.println("------------------------");
        System.out.println("BEFORE METHOD CALL!");
        System.out.println("------------------------");

        productService.changeName(-1L);

        System.out.println("------------------------");
        System.out.println("AFTER METHOD CALL!");
        System.out.println("------------------------");

        System.out.println(productRepository.findAll());
    }
}
