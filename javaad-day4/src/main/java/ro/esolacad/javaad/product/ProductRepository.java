package ro.esolacad.javaad.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("SELECT p FROM Product p where p.price > :price")
//    @Query(value = "", nativeQuery = true)
    List<Product> findByPriceGreaterThan(@Param("price") BigDecimal price);

//    Optional<Product> findByName(String name);
    Optional<Product> findFirstByName(String name);
}
