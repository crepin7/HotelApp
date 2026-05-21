# HotelApp 🏨

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17%2B-red)](https://java.com)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-blue)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Maven-3.8%2B-brightgreen)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-orange)](https://www.mysql.com/)

> Application de gestion hôtelière moderne avec JavaFX

## Description

HotelApp est une application de gestion hôtelière complète permettant de gérer les chambres, les réservations, les clients et la facturation. Développée avec JavaFX, elle offre une interface utilisateur moderne et réactive.

## Fonctionnalités

- 🔐 **Authentification** - Connexion sécurisée pour clients et administrateurs
- 🏠 **Gestion des chambres** - CRUD complet des chambres (disponibilité, type, prix)
- 📅 **Réservations** - Création, modification et suivi des réservations
- 👥 **Gestion des clients** - Comptes clients avec historique
- 💰 **Facturation** - Génération de factures PDF
- 💬 **Chat en temps réel** - Communication clients/administrateur
- 📊 **Tableau de bord** - Statistiques et rapports d'occupation
- 🔍 **Recherche avancée** - Filtres et recherche multi-critères
- 📧 **Notifications** - Rappels de réservation par email
- 🌐 **Multilingue** - Support pour plusieurs langues (français, anglais)

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
- **Git** - Gestion de version

## Installation

### Prérequis

- JDK 17 ou supérieur
- MySQL 8.0+
- Maven 3.8+
- Git (optionnel, pour contribuer)

### Configuration base de données

```sql
CREATE DATABASE hotelapp CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- Importer le script SQL fourni dans src/main/resources/schema.sql
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
| `dashboard.fxml` | Tableau de bord administrateur |
| `profile.fxml` | Profil utilisateur |

## Contribution

Les contributions sont les bienvenues ! Veuillez lire notre [guide de contribution](CONTRIBUTING.md) pour plus de détails.

1. Fork le dépôt
2. Créez votre branche de fonctionnalité (`git checkout -b feature/amazing-feature`)
3. Committez vos changements (`git commit -m 'Add some amazing feature'`)
4. Poussez vers la branche (`git push origin feature/amazing-feature`)
5. Ouvrez une Pull Request

## Licence

Distribué sous la licence MIT. Voir `LICENSE` pour plus d'informations.

## Contact

Nom du projet: [https://github.com/crepin7/HotelApp](https://github.com/crepin7/HotelApp)

