package ehb.be.ehbanzaiapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "klant")
public class Klant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Email(message = "Email moet geldig zijn")
    @NotBlank(message = "Email is verplicht")
    @Column(nullable = false)
    private String email;
    
    @Pattern(regexp = "casual|fan|collector", message = "Tier moet 'casual', 'fan' of 'collector' zijn")
    @Column(nullable = false)
    private String tier;
    
    @NotBlank(message = "Adres is verplicht")
    @Column(nullable = false)
    private String adres;
    
    @ManyToMany
    @JoinTable(
        name = "klant_friends",
        joinColumns = @JoinColumn(name = "klant_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Klant> friendList;
    
    public Klant() {}
    
    public Klant(String email, String tier, String adres) {
        this.email = email;
        this.tier = tier;
        this.adres = adres;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTier() {
        return tier;
    }
    
    public void setTier(String tier) {
        this.tier = tier;
    }
    
    public String getAdres() {
        return adres;
    }
    
    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    public List<Klant> getFriendList() {
        return friendList;
    }
    
    public void setFriendList(List<Klant> friendList) {
        this.friendList = friendList;
    }
}