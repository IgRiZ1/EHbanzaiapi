package ehb.be.ehbanzaiapi.controller;

import ehb.be.ehbanzaiapi.model.Boek;
import ehb.be.ehbanzaiapi.model.Klant;
import ehb.be.ehbanzaiapi.model.Reservatie;
import ehb.be.ehbanzaiapi.repository.BoekRepository;
import ehb.be.ehbanzaiapi.repository.KlantRepository;
import ehb.be.ehbanzaiapi.repository.ReservatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservatieController {
    
    @Autowired
    private ReservatieRepository reservatieRepository;
    
    @Autowired
    private KlantRepository klantRepository;
    
    @Autowired
    private BoekRepository boekRepository;
    
    @PostMapping
    public ResponseEntity<Reservatie> createReservatie(@RequestParam Long klantId,
                                                      @RequestParam Long boekId,
                                                      @RequestParam String verwachteLeverdatum) {
        Optional<Klant> klant = klantRepository.findById(klantId);
        Optional<Boek> boek = boekRepository.findById(boekId);
        
        if (klant.isPresent() && boek.isPresent()) {
            LocalDate leverDatum = LocalDate.parse(verwachteLeverdatum);
            Reservatie reservatie = new Reservatie(klant.get(), boek.get(), leverDatum);
            return ResponseEntity.ok(reservatieRepository.save(reservatie));
        }
        
        return ResponseEntity.badRequest().build();
    }
}