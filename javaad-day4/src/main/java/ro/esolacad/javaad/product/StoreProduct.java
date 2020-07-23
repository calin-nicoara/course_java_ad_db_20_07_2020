package ro.esolacad.javaad.product;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StoreProduct {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "STORE_PRODUCT_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "STORE_PRODUCT_SEQ_GEN", sequenceName = "STORE_PRODUCT_SEQ", allocationSize = 1)
    private Long id;

    private Integer stock;
    private Long storeId;

    @ManyToOne
    private Product product;

    private Boolean active;
}
