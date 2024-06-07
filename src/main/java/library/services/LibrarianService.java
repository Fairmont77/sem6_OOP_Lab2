package library.services;

import library.models.Librarian;
import library.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    private final LibrarianRepository librarianRepository;  // Змінено назву для точності

    @Autowired
    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public List<Librarian> getAllLibrarians() {  // Змінено назву методу
        return librarianRepository.findAll();
    }

    public Librarian createLibrarian(Librarian librarian) {  // Змінено назву методу та параметра
        return librarianRepository.save(librarian);
    }
}
