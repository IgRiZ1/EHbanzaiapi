package ehb.be.ehbanzaiapi.controller;

import ehb.be.ehbanzaiapi.model.Boek;
import ehb.be.ehbanzaiapi.model.DAO.BoekDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BoekController {
    
    @Autowired
    private BoekDAO boekDAO;
    
    @DeleteMapping
    public ResponseEntity<Void> deleteBoek(@RequestParam Long id) {
        if (boekDAO.existsById(id)) {
            boekDAO.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{genre}")
    public List<Boek> getBoekenByGenre(@PathVariable String genre) {
        return boekDAO.findByGenre(genre);
    }
}