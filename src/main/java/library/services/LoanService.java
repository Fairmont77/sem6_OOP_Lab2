package library.services;

import library.models.Reservation;
import library.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class LoanService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public LoanService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByPatronId(int patronId) {
        return reservationRepository.findByPatronId(patronId);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Transactional
    public int updateReservationStatus(int reservationId, boolean status) {
        return reservationRepository.updateReservationStatus(reservationId, status);
    }

    public Reservation updateReservation(int id, Reservation updatedReservation) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setDate(updatedReservation.getDate());
            reservation.setPatronId(updatedReservation.getPatronId());
            reservation.setLibrarianId(updatedReservation.getLibrarianId());
            reservation.setBookTitle(updatedReservation.getBookTitle());
            reservation.setReservationDetails(updatedReservation.getReservationDetails());
            reservation.setStatus(updatedReservation.isStatus());
            return reservationRepository.save(reservation);
        }).orElseGet(() -> {
            updatedReservation.setId(id);
            return reservationRepository.save(updatedReservation);
        });
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsExcludingType(String type) {
        return reservationRepository.findByProcedureNot(type);
    }
}
