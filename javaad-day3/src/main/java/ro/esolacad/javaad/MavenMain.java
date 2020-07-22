package ro.esolacad.javaad;

import ro.esolacad.javaad.dep.TestDependency;

public class MavenMain {

    public static void main(String[] args) {
        System.out.println("Application has started");
        System.out.println(TestDependency.getString());
    }
}
