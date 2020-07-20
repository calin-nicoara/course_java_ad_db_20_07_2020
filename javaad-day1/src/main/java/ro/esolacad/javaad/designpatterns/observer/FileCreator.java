package ro.esolacad.javaad.designpatterns.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FileCreator {

    private final PropertyChangeSupport propertyChangeSupport;

    public FileCreator(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void createFile(final String fileContents) {
        // Created file
        propertyChangeSupport.firePropertyChange(EventTypes.FILE_CREATED.name(), null, fileContents);
    }
}
