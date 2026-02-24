package com.hotelapp.repository;

import com.hotelapp.model.Chambre;
import com.hotelapp.util.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository pour la gestion des chambres
 */
public class ChambreRepository {

    public List<Chambre> findAll() throws SQLException {
        List<Chambre> chambres = new ArrayList<>();
        String sql = "SELECT * FROM chambres ORDER BY numero";

        try (Connection conn = DatabaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                chambres.add(mapResultSetToChambre(rs));
            }
        }
        return chambres;
    }

    public Optional<Chambre> findById(int id) throws SQLException {
        String sql = "SELECT * FROM chambres WHERE id = ?";

        try (Connection conn = DatabaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToChambre(rs));
                }
            }
        }
        return Optional.empty();
    }

    public List<Chambre> findDisponibles() throws SQLException {
        List<Chambre> chambres = new ArrayList<>();
        String sql = "SELECT * FROM chambres WHERE disponible = true ORDER BY numero";

        try (Connection conn = DatabaseConfig.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                chambres.add(mapResultSetToChambre(rs));
            }
        }
        return chambres;
    }

    public int save(Chambre chambre) throws SQLException {
        String sql = "INSERT INTO chambres (numero, type, prix, disponible, description, capacite) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, chambre.getNumero());
            stmt.setString(2, chambre.getType().name());
            stmt.setDouble(3, chambre.getPrix());
            stmt.setBoolean(4, chambre.isDisponible());
            stmt.setString(5, chambre.getDescription());
            stmt.setInt(6, chambre.getCapacite());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void update(Chambre chambre) throws SQLException {
        String sql = "UPDATE chambres SET numero = ?, type = ?, prix = ?, disponible = ?, description = ?, capacite = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chambre.getNumero());
            stmt.setString(2, chambre.getType().name());
            stmt.setDouble(3, chambre.getPrix());
            stmt.setBoolean(4, chambre.isDisponible());
            stmt.setString(5, chambre.getDescription());
            stmt.setInt(6, chambre.getCapacite());
            stmt.setInt(7, chambre.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM chambres WHERE id = ?";

        try (Connection conn = DatabaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Chambre mapResultSetToChambre(ResultSet rs) throws SQLException {
        Chambre chambre = new Chambre();
        chambre.setId(rs.getInt("id"));
        chambre.setNumero(rs.getString("numero"));
        chambre.setType(Chambre.TypeChambre.valueOf(rs.getString("type")));
        chambre.setPrix(rs.getDouble("prix"));
        chambre.setDisponible(rs.getBoolean("disponible"));
        chambre.setDescription(rs.getString("description"));
        chambre.setCapacite(rs.getInt("capacite"));
        return chambre;
    }
}
