package ro.esolacad.javaad.java8;

@FunctionalInterface
public interface ShowANumber {
    void showANumber(String label, Integer value);

    default void showABigNumber(String label, Integer value) {
        showANumber(label.toUpperCase(), value * 100);
    }
}
