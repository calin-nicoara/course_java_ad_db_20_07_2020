package ro.esolacad.javaad.product;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private String brand;
    private List<StoreProductModel> storeProductList;
}
