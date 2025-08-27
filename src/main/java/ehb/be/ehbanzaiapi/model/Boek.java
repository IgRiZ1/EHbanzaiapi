package ehb.be.ehbanzaiapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "boek")
public class Boek {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Naam is verplicht")
    @Column(nullable = false)
    private String naam;
    
    @NotBlank(message = "Omschrijving is verplicht")
    @Column(nullable = false)
    private String omschrijving;
    
    @NotBlank(message = "Genre is verplicht")
    @Column(nullable = false)
    private String genre;
    
    @NotNull(message = "Prijs is verplicht")
    @DecimalMin(value = "1.5", message = "Prijs moet minimaal €1.5 zijn")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prijs;
    
    private String reeks;
    
    public Boek() {}
    
    public Boek(String naam, String omschrijving, String genre, BigDecimal prijs, String reeks) {
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.genre = genre;
        this.prijs = prijs;
        this.reeks = reeks;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    public String getOmschrijving() {
        return omschrijving;
    }
    
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public BigDecimal getPrijs() {
        return prijs;
    }
    
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
    
    public String getReeks() {
        return reeks;
    }
    
    public void setReeks(String reeks) {
        this.reeks = reeks;
    }
}