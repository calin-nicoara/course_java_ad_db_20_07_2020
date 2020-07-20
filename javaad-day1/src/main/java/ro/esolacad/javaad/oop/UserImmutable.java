package ro.esolacad.javaad.oop;

import java.util.Objects;

public class UserImmutable {

    private final Long id;
    private final String firstName;
    private final String lastName;

    public UserImmutable(final Long id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserImmutable setId(Long id) {
        return new UserImmutable(id, this.firstName, this.firstName);
    }

    @Override
    public String toString() {
        return "UserImmutable{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserImmutable that = (UserImmutable) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
