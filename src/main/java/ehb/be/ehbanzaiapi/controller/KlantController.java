package ehb.be.ehbanzaiapi.controller;

import ehb.be.ehbanzaiapi.model.Klant;
import ehb.be.ehbanzaiapi.model.DAO.KlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class KlantController {
    
    @Autowired
    private KlantDAO klantDAO;
    
    @GetMapping
    public List<Klant> getAllKlanten() {
        return klantDAO.findAll();
    }
    
    @GetMapping("/friends/search")
    public ResponseEntity<List<Klant>> getFriendsByKlantId(@RequestParam Long id) {
        Optional<Klant> klant = klantDAO.findById(id);
        if (klant.isPresent()) {
            return ResponseEntity.ok(klant.get().getFriendList());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public Klant createKlant(@RequestParam String email, 
                           @RequestParam String tier, 
                           @RequestParam String adres) {
        Klant klant = new Klant(email, tier, adres);
        return klantDAO.save(klant);
    }
}