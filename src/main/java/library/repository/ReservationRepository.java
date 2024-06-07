package library.repository;

import library.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    // Запит для отримання всіх резервацій за ID патрона
    @Query("SELECT r FROM Reservation r WHERE r.patronId = :patronId")
    List<Reservation> findByPatronId(@Param("patronId") int patronId);

    @Transactional
    @Modifying
    @Query("UPDATE Reservation r SET r.status = :status WHERE r.id = :reservationId")
    int updateReservationStatus(@Param("reservationId") int reservationId, @Param("status") boolean status);

    // Запит для пошуку резервацій, де процедура не включає вказану процедуру
    @Query("SELECT r FROM Reservation r WHERE r.reservationDetails <> :procedure")
    List<Reservation> findByProcedureNot(@Param("procedure") String procedure);
}
