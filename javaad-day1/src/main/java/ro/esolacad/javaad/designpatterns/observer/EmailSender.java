package ro.esolacad.javaad.designpatterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class EmailSender implements PropertyChangeListener {

    private final List<String> messages = new ArrayList<>();

    public void showMessages() {
        System.out.println("Emails: " + messages);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(EventTypes.FILE_CREATED.name())) {
            messages.add((String)evt.getNewValue());
        }
    }
}
