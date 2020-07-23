package ro.esolacad.javaad.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTestIT {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreProductRepository storeProductRepository;

    @Test
    public void testRepo() {
        assert productRepository != null;
    }

    @Test
    public void save() {
        Product productToSave = Product.builder()
                .id(1L)
                .name("Ionut")
                .price(BigDecimal.ONE.setScale(2))
                .brand("Coca-Cola")
                .build();

        productRepository.save(productToSave);
    }

    @Test
    public void delete() {
        save();
        productRepository.deleteById(1L);

        assert productRepository.findAll().size() == 0;
    }

    @Test
    public void testFindByPriceGreater() {
        saveTestProducts();

        List<Product> byPriceGreaterThan = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(5));

        System.out.println(byPriceGreaterThan);
    }

    @Test
    public void testFindByName() {
        saveTestProducts();

        Optional<Product> ionut = productRepository.findFirstByName("Ionut");

        System.out.println(ionut);
    }

    private void saveTestProducts() {
        Product productToSave = Product.builder()
                .id(1L)
                .name("Ionut")
                .price(BigDecimal.ONE.setScale(2))
                .brand("Coca-Cola")
                .build();

        Product productToSave2 = Product.builder()
                .id(2L)
                .name("Ionut")
                .price(BigDecimal.TEN.setScale(2))
                .brand("Coca-Cola")
                .build();

        Product productToSave3 = Product.builder()
                .id(3L)
                .name("Mihai")
                .price(BigDecimal.valueOf(6).setScale(2))
                .brand("Coca-Cola")
                .build();

        productRepository.saveAll(Arrays.asList(productToSave, productToSave2, productToSave3));
    }

    @Test
    @Sql("/sql/add_products.sql")
    @Sql(value = "/sql/delete_all.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindProducts() {
//        Optional<StoreProduct> byId = storeProductRepository.findById(-1L);

        Optional<Product> byId = productRepository.findById(-1L);


    }

}
