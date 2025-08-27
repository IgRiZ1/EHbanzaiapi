package ehb.be.ehbanzaiapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "reservatie")
public class Reservatie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "klant_id", nullable = false)
    @NotNull(message = "Klant is verplicht")
    private Klant klant;
    
    @ManyToOne
    @JoinColumn(name = "boek_id", nullable = false)
    @NotNull(message = "Boek is verplicht")
    private Boek boek;
    
    @Future(message = "Leverdatum moet in de toekomst liggen")
    @NotNull(message = "Verwachte leverdatum is verplicht")
    @Column(nullable = false)
    private LocalDate verwachteLeverdatum;
    
    public Reservatie() {}
    
    public Reservatie(Klant klant, Boek boek, LocalDate verwachteLeverdatum) {
        this.klant = klant;
        this.boek = boek;
        this.verwachteLeverdatum = verwachteLeverdatum;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Klant getKlant() {
        return klant;
    }
    
    public void setKlant(Klant klant) {
        this.klant = klant;
    }
    
    public Boek getBoek() {
        return boek;
    }
    
    public void setBoek(Boek boek) {
        this.boek = boek;
    }
    
    public LocalDate getVerwachteLeverdatum() {
        return verwachteLeverdatum;
    }
    
    public void setVerwachteLeverdatum(LocalDate verwachteLeverdatum) {
        this.verwachteLeverdatum = verwachteLeverdatum;
    }
}