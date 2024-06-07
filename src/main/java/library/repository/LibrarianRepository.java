package library.repository;


import library.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    @Query("SELECT s FROM Librarian s")
    List<Librarian> findAll();
}