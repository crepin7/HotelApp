package com.hotelapp.model;

/**
 * Modèle représentant un utilisateur (admin ou client)
 */
public class Utilisateur {
    private int id;
    private String username;
    private String motDePasse;
    private Role role;
    private int clientId; // Lien vers le client si rôle CLIENT
    private boolean actif;

    public enum Role {
        ADMIN("Administrateur"),
        CLIENT("Client");

        private final String libelle;
        Role(String libelle) { this.libelle = libelle; }
        public String getLibelle() { return libelle; }
    }

    public Utilisateur() {}

    public Utilisateur(String username, String motDePasse, Role role) {
        this.username = username;
        this.motDePasse = motDePasse;
        this.role = role;
        this.actif = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }

    public boolean isAdmin() {
        return role == Role.ADMIN;
    }
}
