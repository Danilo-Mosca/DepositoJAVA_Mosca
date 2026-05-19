package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "runs")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String title;
    
     @Column(nullable = false)
    private LocalDateTime startedOn;
    
     @Column(nullable = false)
    private LocalDateTime completedOn;
    
    @Column(nullable = false)
    private double miles;
    
    //Specifico che tipo di dati restituisce l'enum al database, in questo caso una stringa
    @Enumerated(EnumType.STRING)    // salva il nome dell'enum come stringa ("INDOOR"/"OUTDOOR")
    @Column(nullable = false)
    private Location location;

    // Opzionale, di necessario non è obbligatorio, ma siccome abbiamo un
    // costruttore personalizzato dobbamo creare un costruttore protected vuoto,
    // come di seguito:
    // ── Costruttore no-arg richiesto da JPA ──────────────────────────────────
    protected Run() {
    }

    // ── Costruttore completo per uso applicativo ─────────────────────────────
    public Run(String title, LocalDateTime startedOn, LocalDateTime completedOn,
            double miles, Location location) {
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
    }

    // ── Getter ───────────────────────────────────────────────────────────────
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public double getMiles() {
        return miles;
    }

    public Location getLocation() {
        return location;
    }

    // ── Setter ───────────────────────────────────────────────────────────────
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // ── toString ─────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Run{id=" + id + ", title='" + title + "', miles=" + miles + ", location=" + location + "}";
    }
}
