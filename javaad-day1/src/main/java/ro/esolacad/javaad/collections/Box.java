package ro.esolacad.javaad.collections;

public class Box<T> {

    private T myObject;

    public T getObject() {
        return myObject;
    }

    public void setObject(T objectToSet) {
        myObject = objectToSet;
    }
}
