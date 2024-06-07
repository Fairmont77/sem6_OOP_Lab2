package library.repository;


import library.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Integer> {

    @Query("SELECT p FROM Patron p")
    List<Patron> findAll();
}