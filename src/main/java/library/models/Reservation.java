package library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;
    private int patronId;
    private int librarianId;
    private String bookTitle;
    private String reservationDetails;
    private boolean status;

    public Reservation() {}

    public Reservation(String date, int patronId, int librarianId, String bookTitle, String reservationDetails) {
        this.date = date;
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.bookTitle = bookTitle;
        this.reservationDetails = reservationDetails;
    }

    public Reservation(int id, String date, int patronId, int librarianId, String bookTitle, String reservationDetails) {
        this.id = id;
        this.date = date;
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.bookTitle = bookTitle;
        this.reservationDetails = reservationDetails;
    }

    public Reservation(int id, String date, int patronId, int librarianId, String bookTitle, String reservationDetails, boolean status) {
        this.id = id;
        this.date = date;
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.bookTitle = bookTitle;
        this.reservationDetails = reservationDetails;
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reservation reservation = (Reservation) obj;
        return patronId == reservation.patronId &&
               librarianId == reservation.librarianId &&
               status == reservation.status &&
               Objects.equals(date, reservation.date) &&
               Objects.equals(bookTitle, reservation.bookTitle) &&
               Objects.equals(reservationDetails, reservation.reservationDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, patronId, librarianId, bookTitle, reservationDetails, status);
    }

    @Override
    public String toString() {
        return "Reservation{" +
               "id=" + id +
               ", date='" + date + '\'' +
               ", patronId=" + patronId +
               ", librarianId=" + librarianId +
               ", bookTitle='" + bookTitle + '\'' +
               ", reservationDetails='" + reservationDetails + '\'' +
               ", status=" + status +
               '}';
    }
}
