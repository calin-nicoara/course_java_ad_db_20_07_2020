package ro.esolacad.javaad.oop;

public class SuperUser extends User {

    private boolean isAdmin;

    public SuperUser() {
    }

    public SuperUser(String firstName, String lastName, boolean isAdmin) {
        super(firstName, lastName);
        this.isAdmin = isAdmin;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(final boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String getName() {
        return "Super user " + this.getFirstName() + " " + this.getLastName();
    }
}
