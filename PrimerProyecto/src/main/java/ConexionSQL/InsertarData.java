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
import java.sql.ResultSet;
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
    private final Consultas consultas;

    public InsertarData(){
        consultas = new Consultas();
    }
    /**
     * Se encarga de subir el archivo y sus datos a la base de datos
     *
     * @param conexion
     * @param filasAceptadas
     */
    public void cargarDatos(Connection conexion, ArrayList<String> filasAceptadas) {
        String lineaActual = "";
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
                        tienda = new Tienda(atriEntidad[1], atriEntidad[2], atriEntidad[3],
                                Integer.parseInt(atriEntidad[4]));
                        crearTienda(conexion, tienda);
                        break;

                    case "TIEMPO":
                        tiempo = new Tiempo(auxIdTiempo, atriEntidad[1], atriEntidad[2], Integer.parseInt(atriEntidad[3]));
                        auxIdTiempo++;
                        crearTiempo(conexion, tiempo);
                        break;

                    case "PRODUCTO":
                        producto = new Producto(atriEntidad[1], atriEntidad[2], atriEntidad[3],
                                Double.parseDouble(atriEntidad[4]), Integer.parseInt(atriEntidad[5]), atriEntidad[6]);
                        crearProducto(conexion, producto);
                        break;

                    case "EMPLEADO":
                        empleado = new Empleado(atriEntidad[1], Integer.parseInt(atriEntidad[2]),
                                Integer.parseInt(atriEntidad[3]), Integer.parseInt(atriEntidad[4]));
                        crearEmpleado(conexion, empleado);
                        break;

                    case "CLIENTE":
                        cliente = new Cliente(atriEntidad[1], atriEntidad[2],
                                Integer.parseInt(atriEntidad[3]), Double.parseDouble(atriEntidad[4]));
                        crearCliente(conexion, cliente);
                        break;

                    case "PEDIDO":
                        int idPedido = Integer.parseInt(atriEntidad[1]);
                        double auxTotal = Double.parseDouble(atriEntidad[8]);
                        int idTiempo;

                        //Se actualiza el total o se ingresa un pedido nuevo
                        if (pedidoExistente(conexion, idPedido)) {
                            paquetePedido = new PaquetePedido(auxIdPP, Integer.parseInt(atriEntidad[1]), atriEntidad[6],
                            Integer.parseInt(atriEntidad[7]), Double.parseDouble(atriEntidad[8]));
                            
                            actualizarTotalPedido(conexion, idPedido, auxTotal);
                            
                        } else {
                            paquetePedido = new PaquetePedido(auxIdPP, idPedido, atriEntidad[6],
                                Integer.parseInt(atriEntidad[7]), Double.parseDouble(atriEntidad[8]));
                            
                            //Obtenemos el id tiempo para colocarlo en el pedido nuevo
                            idTiempo =  consultas.idTiempo(conexion, lineaActual, lineaActual);
                            
                            pedido = new Pedido(Date.valueOf(atriEntidad[4]), atriEntidad[5], auxTotal,
                                    Double.parseDouble(atriEntidad[9]), idPedido,
                                    atriEntidad[2], atriEntidad[3], idTiempo);
                            crearPedido(conexion, pedido);
                        }
                        crearPaquetePedido(conexion, paquetePedido);                        
                        break;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean pedidoExistente(Connection conexion, int codigoPedido) {
        String query = "SELECT id FROM PEDIDO WHERE codigo = ?";
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)){
            
            preSt.setInt(1, codigoPedido);
            ResultSet rs = preSt.executeQuery();
            
            if (rs.next()) {
                return true;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con el codigo Pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void crearTienda(Connection conexion, Tienda tienda) {
        String query = "INSERT INTO Tienda VALUES (?,?,?,?,?,?,?)";
     
        String codigo = tienda.getCodigo();
        String nombre = tienda.getNombre();
        String direccion = tienda.getDireccion();
        int telefono_1 = tienda.getTelefono1();
        int telefono_2 = tienda.getTelefono2();
        String horario = tienda.getHorario();
        String correoElectronico = tienda.getCorreoElectronico();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, direccion);
            preSt.setInt(4, telefono_1);
            preSt.setInt(5, telefono_2);
            preSt.setString(6, horario);
            preSt.setString(7, correoElectronico);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+". Error en datos de tienda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    
    public void crearTiempo(Connection conexion, Tiempo tiempo) {
        String query = "INSERT INTO Tienda VALUES (?,?,?,?)";
        
        int idTiempo = tiempo.getIdTiempo();
        String codigoTienda1 = tiempo.getCodigoTienda1();
        String codigoTienda2 = tiempo.getCodigoTienda2();
        int tiempoTiendas = tiempo.getTiempoTiendas();
        
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setInt(1, idTiempo);
            preSt.setString(2, codigoTienda1);
            preSt.setString(3, codigoTienda2);
            preSt.setInt(4, tiempoTiendas);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+". Error en los tiempos", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }  
    

    public void crearProducto(Connection conexion, Producto producto) {
        String query = "INSERT INTO Producto VALUES (?,?,?,?)";
        
        int idTiempo = tiempo.getIdTiempo();
        String codigoTienda1 = tiempo.getCodigoTienda1();
        String codigoTienda2 = tiempo.getCodigoTienda2();
        int tiempoTiendas = tiempo.getTiempoTiendas();
        
        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setInt(1, idTiempo);
            preSt.setString(2, codigoTienda1);
            preSt.setString(3, codigoTienda2);
            preSt.setInt(4, tiempoTiendas);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+". Error en los tiempos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearEmpleado(Connection conexion, Empleado empleado) {

    }

    public void crearCliente(Connection conexion, Cliente cliente) {

    }

    public void crearVenta(Connection conexion, Venta venta) {

    }

    public void crearPedido(Connection conexion, Pedido pedido) {

    }
    
    public void crearPaquetePedido(Connection conexion, PaquetePedido paqueteP){
        String query = "INSERT INTO Paquete_Pedido VALUES (?,?,?,?,?)";
        int idPaquetePedido = paqueteP.getIdPaquetePedido();
        int codigoPedido = paqueteP.getCodigoPedido();
        String idProducto = paqueteP.getIdProducto();
        int cantidad = paqueteP.getCantidad();
        double total = paqueteP.getTotal();
    }
    
    public void actualizarTotalPedido(Connection conexion, int codigoPedido, Double cantSumar){
        
    }
}
