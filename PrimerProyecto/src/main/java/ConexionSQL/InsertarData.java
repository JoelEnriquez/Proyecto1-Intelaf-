/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import EntidadesCompra.Pedido;
import EntidadesCompra.Venta;
import EntidadesPersona.*;
import EntidadesTienda.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class InsertarData {
    
    private Tienda tienda;
    private Tiempo tiempo;
    private Producto producto;
    private Empleado empleado;
    private Cliente cliente;
    private Pedido pedido;
    private PaquetePedido paquetePedido;
    
    /**
     * Se encarga de subir el archivo y sus datos a la base de datos
     * @param conexion
     * @param filasAceptadas 
     */
    public void cargarDatos(Connection conexion, ArrayList<String> filasAceptadas){
        String lineaActual="";
        String[] atriEntidad;
        int auxIdTiempo = 1;
        int auxIdPP = 1;
        

        try {
            for (int i = 0; i < filasAceptadas.size(); i++) {
                lineaActual = filasAceptadas.get(i);
                atriEntidad = lineaActual.split(","); //Separamos los atributos entidad para
                //saber a que entidad corresponde dicha linea
                switch (atriEntidad[0]) {
                    case "TIENDA":
                        tienda = new Tienda(atriEntidad[1], atriEntidad[2],atriEntidad[3],
                                Integer.parseInt(atriEntidad[4]));
                        crearTienda(conexion,tienda);
                        break;
                        
                    case "TIEMPO":
                        tiempo = new Tiempo(auxIdTiempo,atriEntidad[1], atriEntidad[2], Integer.parseInt(atriEntidad[3]));
                        auxIdTiempo++;
                        crearTiempo(conexion,tiempo);
                        break;
                        
                    case "PRODUCTO":
                        producto = new Producto(atriEntidad[1], atriEntidad[2], atriEntidad[3],
                                Double.parseDouble(atriEntidad[4]), Integer.parseInt(atriEntidad[5]), atriEntidad[6]);
                        crearProducto(conexion,producto);
                        break;
                        
                    case "EMPLEADO":
                        empleado = new Empleado(atriEntidad[1], Integer.parseInt(atriEntidad[2]),
                                Integer.parseInt(atriEntidad[3]), Integer.parseInt(atriEntidad[4]));
                        crearEmpleado(conexion,empleado);
                        break;
                        
                    case "CLIENTE":
                        cliente = new Cliente(atriEntidad[1], atriEntidad[2],
                                Integer.parseInt(atriEntidad[3]), Double.parseDouble(atriEntidad[4]));
                        crearCliente(conexion,cliente);
                        break;
                        
                    default:
                        pedido = new Pedido(Date.valueOf(atriEntidad[4]), atriEntidad[5], i,
                                Double.parseDouble(atriEntidad[9]), Integer.parseInt(atriEntidad[1]),
                                atriEntidad[2], atriEntidad[3], i);
                        paquetePedido = new PaquetePedido(auxIdPP, Integer.parseInt(atriEntidad[1]), atriEntidad[6],
                                Integer.parseInt(atriEntidad[7]), Double.parseDouble(atriEntidad[8]));
                        
                        crearPedido(conexion,pedido);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void crearTienda(Connection conexion,Tienda tienda){
        String query = "INSERT INTO Tienda VALUES (?,?,?,?,?,?,?)";
        String codigo = "1234";
        String nombre = "Marianna";
        String direccion = "Alvarado";
        String telefono_1 = "25836923";
        String telefono_2 = "25836923";
        String horario = "25836923";
        String correo_electronico = "25836923";

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            //preSt.setString(3, apellido);
            //preSt.setString(4, telefono);

            preSt.executeUpdate();

            System.out.println("Cliente agregado");

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void crearTiempo(Connection conexion, Tiempo tiempo){
        
    }
    
    public void crearProducto(Connection conexion, Producto producto){
        
    }
    
    public void crearEmpleado(Connection conexion, Empleado empleado){
        
    }
    
    public void crearCliente(Connection conexion, Cliente cliente){
        
    }
    
    public void crearVenta(Connection conexion, Venta venta){
        
    }
    
    public void crearPedido(Connection conexion, Pedido pedido){
        
    }
}
