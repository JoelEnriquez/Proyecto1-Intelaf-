/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

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
public class ConsultasProducto {

    public void obtenerTodosLosProductos(Connection conexion, ArrayList<String[]> tablaProducto, String tiendaActual) {
        
        String query = "SELECT P.*,B.cantidad FROM Producto P LEFT JOIN "
                + "Bodega B ON P.codigo = B.codigo_producto WHERE B.codigo_tienda=? ORDER BY P.codigo DESC";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, tiendaActual);
            
            ResultSet rs = ps.executeQuery();
            
            //Llenado de los nombres de las columnas
            ResultSetMetaData meta = rs.getMetaData();
            int auxTamaño = meta.getColumnCount();            
            String[] nombreColumnas = new String[auxTamaño];
            
            /**
             * Despues se llenan al arr de string
             */
            for (int i = 0; i < nombreColumnas.length; i++) {
                nombreColumnas[i] = meta.getColumnName(i+1);
            }
            
            tablaProducto.add(nombreColumnas);

            while (rs.next()) {
                
                String[] fila = new String[auxTamaño];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(i+1);
                }
                
                tablaProducto.add(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void obtenerPorNombre(Connection conexion, ArrayList<String[]> tablaProducto, String tiendaActual, String filtroNombre) {
        
        String query = "SELECT P.*,B.cantidad FROM Producto P LEFT JOIN "
                + "Bodega B ON P.codigo = B.codigo_producto WHERE B.codigo_tienda=? "
                + "AND P.nombre LIKE ? ORDER BY P.codigo DESC";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, tiendaActual);
            ps.setString(2, "%"+filtroNombre+"%");
            
            ResultSet rs = ps.executeQuery();
            
            //Llenado de los nombres de las columnas
            ResultSetMetaData meta = rs.getMetaData();
            int auxTamaño = meta.getColumnCount();            
            String[] nombreColumnas = new String[auxTamaño];
            
            /**
             * Despues se llenan al arr de string
             */
            for (int i = 0; i < nombreColumnas.length; i++) {
                nombreColumnas[i] = meta.getColumnName(i+1);
            }
            
            tablaProducto.add(nombreColumnas);

            while (rs.next()) {
                
                String[] fila = new String[auxTamaño];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(i+1);
                }
                
                tablaProducto.add(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void obtenerPorCodigo(Connection conexion, ArrayList<String[]> tablaProducto, String tiendaActual, String filtroCodigo) {
        
        String query = "SELECT P.*,B.cantidad FROM Producto P LEFT JOIN "
                + "Bodega B ON P.codigo = B.codigo_producto WHERE B.codigo_tienda=? "
                + "AND P.codigo LIKE ? ORDER BY P.codigo DESC";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, tiendaActual);
            ps.setString(2, "%"+filtroCodigo+"%");
            
            ResultSet rs = ps.executeQuery();
            
            //Llenado de los nombres de las columnas
            ResultSetMetaData meta = rs.getMetaData();
            int auxTamaño = meta.getColumnCount();            
            String[] nombreColumnas = new String[auxTamaño];
            
            /**
             * Despues se llenan al arr de string
             */
            for (int i = 0; i < nombreColumnas.length; i++) {
                nombreColumnas[i] = meta.getColumnName(i+1);
            }
            
            tablaProducto.add(nombreColumnas);

            while (rs.next()) {
                
                String[] fila = new String[auxTamaño];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(i+1);
                }
                
                tablaProducto.add(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void obtenerPorTienda(Connection conexion, ArrayList<String[]> tablaProducto, String filtroTienda) {
        
        String query = "SELECT P.*,B.cantidad,B.codigo_tienda FROM Producto P LEFT JOIN "
                + "Bodega B ON P.codigo = B.codigo_producto WHERE "
                + "B.codigo_tienda LIKE ? ORDER BY P.codigo DESC";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, "%"+filtroTienda+"%");
            
            ResultSet rs = ps.executeQuery();
            
            //Llenado de los nombres de las columnas
            ResultSetMetaData meta = rs.getMetaData();
            int auxTamaño = meta.getColumnCount();            
            String[] nombreColumnas = new String[auxTamaño];
            
            /**
             * Despues se llenan al arr de string
             */
            for (int i = 0; i < nombreColumnas.length; i++) {
                nombreColumnas[i] = meta.getColumnName(i+1);
            }
            
            tablaProducto.add(nombreColumnas);

            while (rs.next()) {
                
                String[] fila = new String[auxTamaño];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(i+1);
                }
                
                tablaProducto.add(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tienda", "Fallo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
