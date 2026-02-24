package com.hotelapp.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Modèle représentant une chambre de l'hôtel
 */
public class Chambre {
    private int id;
    private String numero;
    private TypeChambre type;
    private double prix;
    private boolean disponible;
    private String description;
    private int capacite;

    public enum TypeChambre {
        SIMPLE("Simple", 1),
        DOUBLE("Double", 2),
        SUITE("Suite", 4),
        PRESIDENTIELLE("Présidentielle", 6);

        private final String libelle;
        private final int capaciteMax;

        TypeChambre(String libelle, int capaciteMax) {
            this.libelle = libelle;
            this.capaciteMax = capaciteMax;
        }

        public String getLibelle() { return libelle; }
        public int getCapaciteMax() { return capaciteMax; }
    }

    public Chambre() {}

    public Chambre(int id, String numero, TypeChambre type, double prix, boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.type = type;
        this.prix = prix;
        this.disponible = disponible;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public TypeChambre getType() { return type; }
    public void setType(TypeChambre type) { this.type = type; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chambre chambre = (Chambre) o;
        return id == chambre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Chambre " + numero + " - " + (type != null ? type.getLibelle() : "N/A");
    }
}
