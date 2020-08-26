/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Conexion {
    
    private static final String URL="jdbc:mysql://localhost:3306/INTELAF";
    private String user;
    private String password;
    private Connection connection;

    public Conexion(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public void crearConexion(){
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
