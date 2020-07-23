package ro.esolacad.javaad.product;

import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "PRODUCT_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal price;
    private String brand;

//    @OneToMany
//    private Set<StoreProduct> storeProducts;

//    @Enumerated(EnumType.STRING)
//    private ProductStatus productStatus;
//
//    @Type(type = "org.hibernate.type.LocalDateType")
//    private LocalDate localDate;
}
