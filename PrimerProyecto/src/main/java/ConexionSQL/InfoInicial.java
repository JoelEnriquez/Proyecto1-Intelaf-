/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class InfoInicial {
    
    
    public ArrayList<String> getCodigoTiendas(Connection conexion){
        String query = "SELECT codigo FROM Tienda";
        ArrayList<String> codigosTienda = new ArrayList<>();
        
        try (Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                codigosTienda.add(rs.getString("codigo"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna tienda", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return codigosTienda;
    }
    
    public ArrayList<String> getCodeEmpleados(Connection conexion){
        String query = "SELECT codigo FROM Empleado";
        ArrayList<String> codigosEmplado = new ArrayList<>();
        
        try (Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                codigosEmplado.add(rs.getString("codigo"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado codigo de empleados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return codigosEmplado;
    }
}
