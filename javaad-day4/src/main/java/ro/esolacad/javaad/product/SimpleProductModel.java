package ro.esolacad.javaad.product;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SimpleProductModel {

    private Long id;

    @NotNull
    private String name;

    @Min(1)
    private BigDecimal price;

    @NotBlank
    private String brand;
}
