package ehb.be.ehbanzaiapi.controller;

import ehb.be.ehbanzaiapi.model.Boek;
import ehb.be.ehbanzaiapi.model.Klant;
import ehb.be.ehbanzaiapi.model.Reservatie;
import ehb.be.ehbanzaiapi.model.DAO.BoekDAO;
import ehb.be.ehbanzaiapi.model.DAO.KlantDAO;
import ehb.be.ehbanzaiapi.model.DAO.ReservatieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservatieController {
    
    @Autowired
    private ReservatieDAO reservatieDAO;
    
    @Autowired
    private KlantDAO klantDAO;
    
    @Autowired
    private BoekDAO boekDAO;
    
    @PostMapping
    public ResponseEntity<Reservatie> createReservatie(@RequestParam Long klantId,
                                                      @RequestParam Long boekId,
                                                      @RequestParam String verwachteLeverdatum) {
        Optional<Klant> klant = klantDAO.findById(klantId);
        Optional<Boek> boek = boekDAO.findById(boekId);
        
        if (klant.isPresent() && boek.isPresent()) {
            LocalDate leverDatum = LocalDate.parse(verwachteLeverdatum);
            Reservatie reservatie = new Reservatie(klant.get(), boek.get(), leverDatum);
            return ResponseEntity.ok(reservatieDAO.save(reservatie));
        }
        
        return ResponseEntity.badRequest().build();
    }
}