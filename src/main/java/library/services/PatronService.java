package library.services;

import library.models.Patron;
import library.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {

    private final PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(int id, Patron updatedPatron) {
        return patronRepository.findById(id).map(patron -> {
            patron.setLastName(updatedPatron.getLastName());
            patron.setFirstName(updatedPatron.getFirstName());
            patron.setPatronymic(updatedPatron.getPatronymic());
            patron.setSex(updatedPatron.getSex());
            patron.setDateOfBirth(updatedPatron.getDateOfBirth());
            patron.setPhone(updatedPatron.getPhone());
            patron.setPassword(updatedPatron.getPassword());
            return patronRepository.save(patron);
        }).orElseThrow(() -> new RuntimeException("Patron not found with id " + id));
    }

    public void deletePatron(int id) {
        if (!patronRepository.existsById(id)) {
            throw new RuntimeException("Patron not found with id " + id);
        }
        patronRepository.deleteById(id);
    }
}
