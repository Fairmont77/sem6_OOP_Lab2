package library.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "librarians")
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String email;
    private String position;
    private String password;

    public Librarian() {}

    public Librarian(String lastName, String firstName, String patronymic, String position, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Librarian librarian = (Librarian) obj;
        return id == librarian.id &&
               Objects.equals(lastName, librarian.lastName) &&
               Objects.equals(firstName, librarian.firstName) &&
               Objects.equals(patronymic, librarian.patronymic) &&
               Objects.equals(email, librarian.email) &&
               Objects.equals(position, librarian.position) &&
               Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, patronymic, email, position, password);
    }

    @Override
    public String toString() {
        return "Librarian{" +
               "id=" + id +
               ", lastName='" + lastName + '\'' +
               ", firstName='" + firstName + '\'' +
               ", patronymic='" + patronymic + '\'' +
               ", position='" + position + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
