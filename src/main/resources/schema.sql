-- HotelApp Database Schema
-- Version 1.0

-- Utilisateurs table
CREATE TABLE IF NOT EXISTS utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'CLIENT') NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    actif BOOLEAN DEFAULT TRUE
);

-- Chambres table
CREATE TABLE IF NOT EXISTS chambre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(10) UNIQUE NOT NULL,
    type ENUM('SIMPLE', 'DOUBLE', 'SUITE', 'DELUXE') NOT NULL,
    prix DECIMAL(10,2) NOT NULL,
    statut ENUM('DISPONIBLE', 'OCCUPEE', 'MAINTENANCE') DEFAULT 'DISPONIBLE',
    description TEXT,
    capacite INT DEFAULT 1
);

-- Clients table
CREATE TABLE IF NOT EXISTS client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateur_id INT UNIQUE,
    telephone VARCHAR(20),
    adresse TEXT,
    date_naissance DATE,
    FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE
);

-- Réservations table
CREATE TABLE IF NOT EXISTS reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    chambre_id INT NOT NULL,
    date_arrivee DATE NOT NULL,
    date_depart DATE NOT NULL,
    statut ENUM('CONFIRMEE', 'ANNULEE', 'TERMINEE') DEFAULT 'CONFIRMEE',
    nombre_personnes INT DEFAULT 1,
    prix_total DECIMAL(10,2),
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (chambre_id) REFERENCES chambre(id) ON DELETE CASCADE,
    CHECK (date_depart > date_arrivee)
);

-- Factures table
CREATE TABLE IF NOT EXISTS facture (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reservation_id INT UNIQUE,
    montant DECIMAL(10,2) NOT NULL,
    date_facturation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_echeance DATE,
    statut ENUM('NON_PAYEE', 'PARTIELLEMENT_PAYEE', 'PAYEE', 'ANNULEE') DEFAULT 'NON_PAYEE',
    mode_paiement ENUM('ESPECE', 'CARTE', 'VIREMENT', 'CHEQUE'),
    FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE
);

-- Indexes pour améliorer les performances
CREATE INDEX idx_reservation_client ON reservation(client_id);
CREATE INDEX idx_reservation_chambre ON reservation(chambre_id);
CREATE INDEX idx_reservation_dates ON reservation(date_arrivee, date_depart);
CREATE INDEX idx_utilisateur_email ON utilisateur(email);
CREATE INDEX idx_chambre_type ON chambre(type);
CREATE INDEX idx_chambre_statut ON chambre(statut);

-- Données d'exemple (optionnel)
-- INSERT INTO utilisateur (nom, prenom, email, mot_de_passe, role) VALUES
-- ('Admin', 'System', 'admin@hotelapp.com', '$2a$10$hashedpasswordhere', 'ADMIN');

