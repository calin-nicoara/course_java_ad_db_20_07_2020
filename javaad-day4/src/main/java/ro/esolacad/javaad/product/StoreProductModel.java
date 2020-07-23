package ro.esolacad.javaad.product;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StoreProductModel {

    private Integer stock;
    private Long storeId;
    private Boolean active;
}
