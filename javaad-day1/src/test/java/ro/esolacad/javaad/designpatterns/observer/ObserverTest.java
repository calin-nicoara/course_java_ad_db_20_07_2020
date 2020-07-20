package ro.esolacad.javaad.designpatterns.observer;

import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void testObserver() {
        EmailSender emailSender = new EmailSender();
        FileCreator fileCreator = new FileCreator();

        fileCreator.addPropertyChangeListener(emailSender);

        emailSender.showMessages();

        fileCreator.createFile("new file");

        emailSender.showMessages();
    }
}
