package com.app.productos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_productos?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el controlador de la base de datos", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión a la base de datos", e);
        }
    }
}
