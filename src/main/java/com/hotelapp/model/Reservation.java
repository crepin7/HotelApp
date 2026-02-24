package com.hotelapp.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Modèle représentant une réservation
 */
public class Reservation {
    private int id;
    private int idClient;
    private int idChambre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;
    private double montantTotal;
    private LocalDate dateCreation;

    public enum StatutReservation {
        EN_ATTENTE("En attente"),
        CONFIRMEE("Confirmée"),
        ANNULEE("Annulée"),
        TERMINEE("Terminée");

        private final String libelle;

        StatutReservation(String libelle) { this.libelle = libelle; }
        public String getLibelle() { return libelle; }
    }

    public Reservation() {
        this.dateCreation = LocalDate.now();
    }

    public Reservation(int idClient, int idChambre, LocalDate dateDebut, LocalDate dateFin) {
        this();
        this.idClient = idClient;
        this.idChambre = idChambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = StatutReservation.EN_ATTENTE;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }

    public int getIdChambre() { return idChambre; }
    public void setIdChambre(int idChambre) { this.idChambre = idChambre; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public StatutReservation getStatut() { return statut; }
    public void setStatut(StatutReservation statut) { this.statut = statut; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public long getNombreNuits() {
        if (dateDebut == null || dateFin == null) return 0;
        return java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
