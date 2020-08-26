/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class ReportesProducto {
    
    public void pedidosDeCliente(Connection conexion, String NIT, ArrayList<String[]> resultPedido, String estadoP){
        String query = "SELECT * FROM Pedido WHERE NIT_cliente=? AND estado_pedido = ?";
        
        estadoP = "En curso";
        
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, NIT);
            ps.setString(2, estadoP);
            
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData resultMeta = rs.getMetaData();
            
            int aux = resultMeta.getColumnCount();
            String[] fila = new String[aux];
            
            while (rs.next()) {
                for (int i = 0; i < aux; i++) {
                    fila[i] = rs.getString(i+1);
                }
                resultPedido.add(fila);
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado pedidos de cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
