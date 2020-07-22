package ro.esolacad.javaad.jdbc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDBTest {

    @Test
    public void getProducts() throws SQLException {
        ProductDB productDB = new ProductDB();

        List<Product> productList = productDB.getProducts();

        System.out.println(productList);

        assert productList.size() == 2;
    }

    @Test
    public void saveProduct() throws SQLException {
        Product product = new Product(4L,"Dero Lichid", BigDecimal.valueOf(20),"Dero");

        ProductDB productDB = new ProductDB();

        productDB.saveProduct(product);

        //TODO delete product after test
    }

    @Test
    public void updateProduct() throws SQLException {
        Product product = new Product(1L,"Coca-Cola NOU", BigDecimal.valueOf(5),"Coca-Cola");

        ProductDB productDB = new ProductDB();

        productDB.updateProduct(product);
    }

}
