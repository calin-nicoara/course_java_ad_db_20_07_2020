package ro.esolacad.javaad.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreProductRepository extends JpaRepository<StoreProduct, Long> {

    List<StoreProduct> findByProduct(Product product);
}
