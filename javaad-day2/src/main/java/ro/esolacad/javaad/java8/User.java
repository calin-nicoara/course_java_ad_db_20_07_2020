package ro.esolacad.javaad.java8;

import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private Long id;

    private String firstName;
    private String lastName;
    private List<Integer> reviews;
    private Boolean isAdmin;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, List<Integer> reviews) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviews = reviews;
    }

    public User(String firstName, String lastName, List<Integer> reviews, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviews = reviews;
        this.isAdmin = isAdmin;
    }

    public User() {}

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public List<Integer> getReviews() {
        return reviews;
    }

    public void setReviews(final List<Integer> reviews) {
        this.reviews = reviews;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(final Boolean admin) {
        isAdmin = admin;
    }
}
