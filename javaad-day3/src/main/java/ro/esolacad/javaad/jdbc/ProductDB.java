package ro.esolacad.javaad.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private static final String GET_ALL_PRODUCTS = "SELECT id, name, price, brand " +
            "FROM product order by id";

    private static final String INSERT_PRODUCT = "INSERT INTO product(id, name, price, brand) " +
            "VALUES (?, ?, ?, ?)";

    private static final String UPDATE_PRODUCT = "UPDATE product set name = ?, " +
            "price = ?," +
            "brand = ? " +
            "where id = ?";

    public List<Product> getProducts() throws SQLException {
        Connection connection = DriverManagerUtil.getConnection();

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        ResultSet resultSet = statement.executeQuery(GET_ALL_PRODUCTS);

        List<Product> productList = new ArrayList<>();

        while(resultSet.next()) {
            Product product = new Product();

            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getBigDecimal("price"));
            product.setBrand(resultSet.getString("brand"));

            productList.add(product);
        }

        connection.close();

        return productList;
    }

    public Product getProduct(Long id) {
        return null;
    }

    public void saveProduct(final Product product) throws SQLException {
        Connection connection = DriverManagerUtil.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);

        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setBigDecimal(3, product.getPrice());
        preparedStatement.setString(4, product.getBrand());

        preparedStatement.execute();
        connection.commit();

//        connection.rollback();
        connection.close();
    }

    public void updateProduct(final Product product) throws SQLException {
        Connection connection = DriverManagerUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);

        preparedStatement.setString(1, product.getName());
        preparedStatement.setBigDecimal(2, product.getPrice());
        preparedStatement.setString(3, product.getBrand());
        preparedStatement.setLong(4, product.getId());

        preparedStatement.execute();

        connection.close();
    }
}
