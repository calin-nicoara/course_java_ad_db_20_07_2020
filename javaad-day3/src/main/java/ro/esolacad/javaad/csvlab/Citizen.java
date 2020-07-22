package ro.esolacad.javaad.csvlab;

import java.time.LocalDate;
import java.util.Objects;


public class Citizen {

    /**
     * Id of citizen
     */
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private boolean isForeigner;

    public Citizen(final Long id, final String name, final LocalDate dateOfBirth, final boolean isForeigner) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.isForeigner = isForeigner;
    }

    public Citizen() {}

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public void setForeigner(final boolean foreigner) {
        isForeigner = foreigner;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Citizen citizen = (Citizen) o;
        return isForeigner == citizen.isForeigner &&
                Objects.equals(id, citizen.id) &&
                Objects.equals(name, citizen.name) &&
                Objects.equals(dateOfBirth, citizen.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, isForeigner);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isForeigner=" + isForeigner +
                '}';
    }
}
