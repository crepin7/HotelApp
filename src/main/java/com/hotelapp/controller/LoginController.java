package com.hotelapp.controller;

import com.hotelapp.util.DatabaseConfig;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controller for the login screen.
 */
public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusLabel;

    /**
     * Handles the login button click event.
     */
    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter username and password");
            return;
        }

        // TODO: Implement actual authentication using DatabaseConfig
        // For now, just a placeholder
        if ("admin".equals(username) && "admin".equals(password)) {
            statusLabel.setText("Login successful!");
            statusLabel.setStyle("-fx-text-fill: GREEN;");
            // Close login window and open main app (to be implemented)
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();
        } else {
            statusLabel.setText("Invalid username or password");
        }
    }

    /**
     * Handles mouse drag for window movement (if undecorated).
     */
    @FXML
    private void handleMouseDragged(MouseEvent event) {
        // Implementation for dragging window
    }
}
