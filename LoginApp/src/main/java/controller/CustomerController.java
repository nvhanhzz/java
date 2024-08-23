package controller;

import java.sql.*;

public class CustomerController {
    private Connection connection;

    public CustomerController() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "");
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM customers WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true; // Login successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Login failed
    }
}
