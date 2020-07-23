package ro.esolacad.javaad.product;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class ProductSavedEvent extends ApplicationEvent {

    @Getter
    private final Product product;

    public ProductSavedEvent(final Object source, final Product product) {
        super(source);
        this.product = product;
    }
}
