package ro.esolacad.javaad.product;

public class ProductMapper {

    public static  SimpleProductModel toSimpleProductModel(final Product product) {
        return SimpleProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .brand(product.getBrand())
                .build();
    }
}
