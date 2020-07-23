package ro.esolacad.javaad.product;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @EventListener
    public void sendEmailProductCreated(ProductSavedEvent productSavedEvent) {
        System.out.println("Product created: " + productSavedEvent.getProduct());
    }
}
