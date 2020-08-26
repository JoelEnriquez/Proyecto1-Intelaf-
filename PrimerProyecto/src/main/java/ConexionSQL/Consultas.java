/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import EntidadesPersona.Cliente;
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
    
    public int contadorRegistros(Connection conexion){
        String query = "SELECT COUNT(*) FROM Registro";
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
    
    
    public Date obtenerValorUltimoPedido(Connection conexion){
        String query = "SELECT fecha FROM Pedido ORDER BY fecha DESC LIMIT 1;";
        Date dateReciente = null;
        try(Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                dateReciente = rs.getDate("fecha");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la fecha", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return dateReciente;
    }
    
    public Date obtenerValorUltimoRegistro(Connection conexion){
        String query = "SELECT fecha FROM Registro ORDER BY fecha DESC LIMIT 1;";
        Date dateReciente = null;
        
        try(Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                dateReciente = rs.getDate("fecha");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la fecha", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return dateReciente;
    }
    
    
    public int idTiempo(Connection conexion, String codet1, String codet2){
        String query = "SELECT id FROM Tiempo WHERE (codigo_tienda_1 = ? AND codigo_tienda_2 = ?) OR "
                + "(codigo_tienda_1 = ? AND codigo_tienda_2 = ?)";
        String codigot1 = codet1;
        String codigot2 = codet2;
        int idTiempo = 0;       
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigot1);
            preSt.setString(2, codigot2);
            preSt.setString(3, codigot2);
            preSt.setString(4, codigot1);

            ResultSet rs = preSt.executeQuery();
            
            while (rs.next()) {
                idTiempo = rs.getInt("id");
            }
            
            rs.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el id", "Error", JOptionPane.ERROR_MESSAGE);
        }
  
        return idTiempo;
    }
    
    
    public ArrayList<String[]> tablaTiempos(Connection conexion, String tiendaActual, ArrayList<String[]> tablaTiempos){
        String query = "SELECT * FROM Tiempo WHERE codigo_tienda_1 = ? OR codigo_tienda_2 = ?";
        tablaTiempos = new ArrayList<>();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, tiendaActual);

            ResultSet rs = preSt.executeQuery();
            
            while (rs.next()) {
                
                String[] fila = new String[4];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(i+1);
                }
                
                tablaTiempos.add(fila);
            }
            
            rs.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el id", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return tablaTiempos;
    }
    
    
    public void getNIT_Clientes(Connection conexion, ArrayList<String> listadoClientesNIT){
        String query = "SELECT nit FROM Cliente";
        
        try(Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            if (rs.next()) {
                listadoClientesNIT.add(rs.getString("nit"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado los NIT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getCodigoProducto(Connection conexion, ArrayList<String> listadoProductos){
        String query = "SELECT codigo FROM Producto";
        
        try(Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            if (rs.next()) {
                listadoProductos.add(rs.getString("codigo"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado los productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Cliente getCliente(Connection conexion, String NIT){
        String query = "SELECT * FROM Cliente WHERE NIT=?";
        Cliente cliente = null;
    
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, NIT);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cliente = new Cliente(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(9),
                        rs.getString(8), rs.getString(5), rs.getInt(4), rs.getDouble(6), rs.getDouble(7));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado los productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cliente;
    }
    
    public int idPedidoActual(Connection conexion){
        String query = "Select id FROM Pedido ORDER BY id DESC LIMIT 1";
        int idActual = 0;
        
        try(Statement ps = conexion.createStatement();
                ResultSet rs = ps.executeQuery(query)) {
            
            if (rs.next()) {
                idActual = rs.getInt("id");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado los productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idActual;
    }

    public double precioProdcuto(Connection conexion, String codigo ){
        String query = "Select precio FROM Producto WHERE codigo =?";
        double coste = 0;
        
        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                coste = rs.getDouble("precio");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado los productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return coste;
    }
    
    
}
