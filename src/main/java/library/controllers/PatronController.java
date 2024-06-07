package library.controllers;

import library.models.Patron;
import library.services.PatronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3030")
@RequestMapping("/patrons")
public class PatronController {
    private static final Logger logger = LoggerFactory.getLogger(PatronController.class);

    private final PatronService patronService;

    @Autowired
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public List<Patron> getAllPatrons() {
        List<Patron> patrons = patronService.getAllPatrons();
        logger.info("Retrieved all patrons: {}", patrons);
        return patrons;
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        Patron newPatron = patronService.createPatron(patron);
        logger.info("Created new patron: {}", newPatron);
        return newPatron;
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable int id, @RequestBody Patron patron) {
        Patron updatedPatron = patronService.updatePatron(id, patron);
        logger.info("Updated patron with id {}: {}", id, updatedPatron);
        return updatedPatron;
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable int id) {
        patronService.deletePatron(id);
        logger.info("Deleted patron with id {}", id);
    }
}
