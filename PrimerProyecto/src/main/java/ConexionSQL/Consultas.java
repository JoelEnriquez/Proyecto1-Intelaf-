/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Consultas {
    
    
    /**
     * Sirve para consultar alguna tabla y ver si hay datos
     * @param conexion
     * @return 
     */
    public int contadorDatos(Connection conexion){
        String query = "SELECT COUNT(*) FROM Tienda";
        int count = 0;

        try (Statement statement = conexion.createStatement();
                ResultSet result = statement.executeQuery(query)) {
            
            if (result.next()) {
                count = result.getInt(1); //Retorna 0 si la tabla esta vacia
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }       
        return count;
    }
    
    
    public int idTiempo(Connection conexion, String codet1, String codet2){
        String query = "SELECT id FROM TIEMPO WHERE (codigo_tienda_1 = ? AND codigo_tienda_2 = ?) OR "
                + "(codigo_tienda_2 = ? AND codigo_tienda_1 = ?)";
        String codigot1 = codet1;
        String codigot2 = codet2;
        int idTiempo = 0;
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigot1);
            preSt.setString(2, codigot2);
            preSt.setString(3, codigot1);
            preSt.setString(4, codigot2);
            
            ResultSet rs = preSt.executeQuery();
            
            while (rs.next()) {
                idTiempo = rs.getInt("id");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+". No se ha encontrado el id", "Error", JOptionPane.ERROR_MESSAGE);
        }
  
        return idTiempo;
    }
    
    public double totalActualPedido(Connection conexion){
        String query = "SELECT id FROM TIEMPO WHERE  ";
        double totalActual = 0;
        
        return totalActual;
    }
    
    
}
