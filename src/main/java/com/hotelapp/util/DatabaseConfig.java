package com.hotelapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Gestionnaire de connexion à la base de données
 */
public class DatabaseConfig {
    private static final String CONFIG_FILE = "database.properties";
    private static DatabaseConfig instance;
    private Properties properties;

    private DatabaseConfig() {
        properties = new Properties();
        loadProperties();
    }

    public static synchronized DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                // Utiliser les valeurs par défaut
                properties.setProperty("db.url", "jdbc:mysql://localhost:3306/hotelapp");
                properties.setProperty("db.username", "root");
                properties.setProperty("db.password", "");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Erreur chargement config: " + e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        
        return DriverManager.getConnection(url, username, password);
    }

    public String getUrl() { return properties.getProperty("db.url"); }
    public String getUsername() { return properties.getProperty("db.username"); }
}
