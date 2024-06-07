package library.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "patrons")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "sex")
    private String sex;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    public Patron() {}

    public Patron(String lastName, String firstName, String patronymic, String sex, String dateOfBirth, String phone, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patron patron = (Patron) obj;
        return id == patron.id &&
                Objects.equals(lastName, patron.lastName) &&
                Objects.equals(firstName, patron.firstName) &&
                Objects.equals(patronymic, patron.patronymic) &&
                Objects.equals(sex, patron.sex) &&
                Objects.equals(dateOfBirth, patron.dateOfBirth) &&
                Objects.equals(phone, patron.phone) &&
                Objects.equals(password, patron.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, patronymic, sex, dateOfBirth, phone, password);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
