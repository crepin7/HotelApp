# HotelApp 🏨

> Application de gestion hôtelière moderne avec JavaFX

## Description

HotelApp est une application de gestion hôtelière complète permettant de gérer les chambres, les réservations, les clients et la facturation. Développée avec JavaFX, elle offre une interface utilisateur moderne et réactive.

## Fonctionnalités

- 🔐 **Authentification** - Connexion sécurisée pour clients et administrateurs
- 🏠 **Gestion des chambres** - CRUD complet des chambres (disponibilité,类型, prix)
- 📅 **Réservations** - Création, modification et suivi des réservations
- 👥 **Gestion des clients** - Comptes clients avec historique
- 💰 **Facturation** - Génération de factures PDF
- 💬 **Chat en temps réel** - Communication clients/administrateur

## Architecture

```
com.hotelapp/
├── model/           # Modèles de données (DTO/Entities)
├── view/            # Vues FXML et CSS
│   ├── fxml/       # Fichiers FXML
│   └── css/        # Styles CSS
├── controller/      # Contrôleurs JavaFX
├── service/        # Logique métier
├── repository/     # Accès données
└── util/          # Utilitaires
```

## Technologies

- **Java 17+** - Langage
- **JavaFX 21** - Framework UI
- **MySQL** - Base de données
- **JDBC** - Connectivité base de données
- **iText PDF** - Génération PDF
- **Maven** - Gestion des dépendances

## Installation

### Prérequis

- JDK 17 ou supérieur
- MySQL 8.0+
- Maven 3.8+

### Configuration base de données

```sql
CREATE DATABASE hotelapp;
-- Importer le script SQL fourni
```

### Compilation

```bash
mvn clean package
```

### Lancement

```bash
java -jar target/hotelapp-1.0.jar
```

## Structure des vues

| Vue | Description |
|-----|-------------|
| `login.fxml` | Écran de connexion |
| `admin-menu.fxml` | Menu administrateur |
| `client-menu.fxml` | Menu client |
| `rooms.fxml` | Liste des chambres |
| `reservations.fxml` | Gestion des réservations |
| `accounts.fxml` | Gestion des comptes |
| `billing.fxml` | Facturation |
| `chat.fxml` | Interface de chat |

## Contribution

Les contributions sont les bienvenues ! Veuillez créer une branche `feature/` pour vos modifications.

## Licence

Propriétaire - Tous droits réservés
