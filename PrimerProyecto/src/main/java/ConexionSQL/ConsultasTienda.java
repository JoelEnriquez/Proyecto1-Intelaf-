/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class ConsultasTienda {
    
    
    /**
     * Crea un array list de arreglos de string para poder meter la info necesaria
     * @param conexion
     * @param tablaTienda
     * @return 
     */
    public ArrayList<String[]> obtenerTodasLasTiendas(Connection conexion, ArrayList<String[]> tablaTienda){
        String query = "SELECT * FROM Tienda ORDER BY nombre";
        tablaTienda = new ArrayList<>();
        
        try(Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                String codigo = rs.getString(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono1 = rs.getString(4);
                String telefono2 = rs.getString(5);
                String horario = rs.getString(6);
                String correoElectronico = rs.getString(7);
                
                String[] fila = new String[7];
                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = direccion;
                fila[3] = telefono1;
                fila[4] = telefono2;
                fila[5] = horario;
                fila[6] = correoElectronico;
                
                tablaTienda.add(fila);
            }
            
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return tablaTienda;
    }
    
    public ArrayList<String[]> obtenerPorNombre(Connection conexion, ArrayList<String[]> tablaTienda,String filtro){
        String query = "SELECT * FROM Tienda WHERE nombre LIKE ? ORDER BY nombre";
        String filtroNombre = filtro;
        
        tablaTienda = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1,"%"+filtroNombre+"%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String codigo = rs.getString(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono1 = rs.getString(4);
                String telefono2 = rs.getString(5);
                String horario = rs.getString(6);
                String correoElectronico = rs.getString(7);
                
                String[] fila = new String[7];
                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = direccion;
                fila[3] = telefono1;
                fila[4] = telefono2;
                fila[5] = horario;
                fila[6] = correoElectronico;
                
                tablaTienda.add(fila);
            }
            
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return tablaTienda;
    }
    
    public ArrayList<String[]> obtenerPorCodigo(Connection conexion, ArrayList<String[]> tablaTienda,String filtro){
        String query = "SELECT * FROM Tienda WHERE codigo LIKE ? ORDER BY nombre";
        String filtroCodigo = filtro;
        
        tablaTienda = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1,"%"+filtroCodigo+"%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String codigo = rs.getString(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono1 = rs.getString(4);
                String telefono2 = rs.getString(5);
                String horario = rs.getString(6);
                String correoElectronico = rs.getString(7);
                
                String[] fila = new String[7];
                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = direccion;
                fila[3] = telefono1;
                fila[4] = telefono2;
                fila[5] = horario;
                fila[6] = correoElectronico;
                
                tablaTienda.add(fila);
            }
            
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return tablaTienda;
    }
    
    public ArrayList<String[]> obtenerPorAmbosFiltros(Connection conexion, ArrayList<String[]> tablaTienda,
            String filtroCodigo, String filtroNombre){
        String query = "SELECT * FROM Tienda WHERE nombre LIKE ? AND codigo LIKE ? ORDER BY nombre";
        String filtroPorNombre = filtroNombre;
        String filtroPorCodigo = filtroNombre;
        
        
        tablaTienda = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1,"%"+filtroPorNombre+"%");
            ps.setString(2,"%"+filtroPorCodigo+"%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String codigo = rs.getString(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono1 = rs.getString(4);
                String telefono2 = rs.getString(5);
                String horario = rs.getString(6);
                String correoElectronico = rs.getString(7);
                
                String[] fila = new String[7];
                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = direccion;
                fila[3] = telefono1;
                fila[4] = telefono2;
                fila[5] = horario;
                fila[6] = correoElectronico;
                
                tablaTienda.add(fila);
            }
            
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return tablaTienda;
    }
}
