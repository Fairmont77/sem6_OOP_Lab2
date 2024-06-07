package library.controllers;

import library.models.Reservation;
import library.services.LoanService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final LoanService reservationService;

    @Autowired
    public ReservationController(LoanService reservationService) {
        this.reservationService = reservationService;
    }

    @RolesAllowed("librarian")
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @RolesAllowed({"librarian", "patron"})
    @GetMapping("/patron/{patronId}")
    public List<Reservation> getReservationsByPatronId(@PathVariable int patronId) {
        return reservationService.getReservationsByPatronId(patronId);
    }

    @RolesAllowed("librarian")
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @RolesAllowed("librarian")
    @PutMapping("/{id}/status")
    public int updateReservationStatus(@PathVariable int id, @RequestParam Boolean newStatus) {
        return reservationService.updateReservationStatus(id, newStatus);
    }

    @RolesAllowed("librarian")
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @RolesAllowed("librarian")
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
