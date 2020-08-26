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
import java.util.Arrays;
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
    private Bodega bodega;
    private final Consultas consultas;

    public InsertarData() {
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

        //Sirve para que no se repita la info al crear un producto
        String codigoProductoAux = "";

        //Sirven para poner la info correcta en pedido
        String codigoPedidoAux = "";
        ArrayList<Double> totalPedido = totalPedidos(filasAceptadas);
        int auxtotalPedido = 0;

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
                        tiempo = new Tiempo(atriEntidad[1], atriEntidad[2], Integer.parseInt(atriEntidad[3]));
                        crearTiempo(conexion, tiempo);
                        break;

                    case "PRODUCTO":
                        if (atriEntidad[3].equals(codigoProductoAux)) {
                            bodega = new Bodega(atriEntidad[6], atriEntidad[3], Integer.parseInt(atriEntidad[4]));
                        } else {
                            producto = new Producto(atriEntidad[1], atriEntidad[2], atriEntidad[3], Double.parseDouble(atriEntidad[5]));
                            bodega = new Bodega(atriEntidad[6], atriEntidad[3], Integer.parseInt(atriEntidad[4]));

                            codigoProductoAux = atriEntidad[3];//Se cambia al codigo actual para que no se repita
                            crearProducto(conexion, producto);
                        }
                        crearBodega(conexion, bodega);
                        break;

                    case "EMPLEADO":
                        empleado = new Empleado(atriEntidad[1], atriEntidad[2],
                                Integer.parseInt(atriEntidad[3]), atriEntidad[4]);
                        crearEmpleado(conexion, empleado);
                        break;

                    case "CLIENTE":
                        cliente = new Cliente(atriEntidad[1], atriEntidad[2],
                                Integer.parseInt(atriEntidad[3]), Double.parseDouble(atriEntidad[4]));
                        crearCliente(conexion, cliente);
                        break;

                    case "PEDIDO":
                        int idPedido = Integer.parseInt(atriEntidad[1]); //Recibe el id del Pedido actual
                        double subTotalProducto = Double.parseDouble(atriEntidad[8]);
                        int idTiempo = consultas.idTiempo(conexion, atriEntidad[2], atriEntidad[3]);

                        if (codigoPedidoAux.equals(atriEntidad[1])) {
                            paquetePedido = new PaquetePedido(idPedido, atriEntidad[6], Integer.parseInt(atriEntidad[7]), subTotalProducto);
                        } else {
                            pedido = new Pedido(Date.valueOf(atriEntidad[4]), atriEntidad[5], totalPedido.get(auxtotalPedido),
                                    Double.parseDouble(atriEntidad[9]), idPedido, idTiempo);
                            auxtotalPedido++;
                            codigoPedidoAux = atriEntidad[1];
                            paquetePedido = new PaquetePedido(idPedido, atriEntidad[6], Integer.parseInt(atriEntidad[7]), subTotalProducto);

                            crearPedidoTXT(conexion, pedido);
                        }
                        crearPaquetePedido(conexion, paquetePedido);
                        break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean pedidoExistente(Connection conexion, int codigoPedido) {
        String query = "SELECT id FROM PEDIDO WHERE codigo = ?";

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {

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
            JOptionPane.showMessageDialog(null, "Error en datos de tienda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearTiempo(Connection conexion, Tiempo tiempo) {
        String query = "INSERT INTO Tiempo (codigo_tienda_1, codigo_tienda_2, tiempo_tiendas) VALUES (?,?,?)";

        String codigoTienda1 = tiempo.getCodigoTienda1();
        String codigoTienda2 = tiempo.getCodigoTienda2();
        int tiempoTiendas = tiempo.getTiempoTiendas();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigoTienda1);
            preSt.setString(2, codigoTienda2);
            preSt.setInt(3, tiempoTiendas);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los tiempos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearProducto(Connection conexion, Producto producto) {
        String query = "INSERT INTO Producto VALUES (?,?,?,?,?,?)";

        String codigoProducto = producto.getCodigo();
        String nombreProducto = producto.getNombre();
        String nombreFabricante = producto.getFabricante();
        double precio = producto.getPrecio();
        String descripcion = producto.getDescripcion();
        String garantia = producto.getGarantia();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigoProducto);
            preSt.setString(2, nombreProducto);
            preSt.setString(3, nombreFabricante);
            preSt.setDouble(4, precio);
            preSt.setString(5, descripcion);
            preSt.setString(6, garantia);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearBodega(Connection conexion, Bodega bodega) {
        String query = "INSERT INTO Bodega (codigo_tienda, codigo_producto, cantidad) VALUES (?,?,?)";

        String codigoTienda = bodega.getCodigoTienda();
        String codigoProducto = bodega.getCodigoProducto();
        int cantidadProducto = bodega.getCantidadProducto();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigoTienda);
            preSt.setString(2, codigoProducto);
            preSt.setInt(3, cantidadProducto);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos de bodega.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearEmpleado(Connection conexion, Empleado empleado) {
        String query = "INSERT INTO Empleado VALUES (?,?,?,?,?,?,?,?)";

        String codigoEmpleado = empleado.getCodigoEmpleado();
        String nombre = empleado.getNombre();
        String apellido = empleado.getApellido();
        int telefono = empleado.getTelefono();
        String DPI = empleado.getDPI();
        String direccion = empleado.getDireccion();
        String correoElectronico = empleado.getCorreoElectronico();
        String NIT = empleado.getNIT();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigoEmpleado);
            preSt.setString(2, nombre);
            preSt.setString(3, apellido);
            preSt.setInt(4, telefono);
            preSt.setString(5, DPI);
            preSt.setString(6, direccion);
            preSt.setString(7, correoElectronico);
            preSt.setString(8, NIT);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos de empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearCliente(Connection conexion, Cliente cliente) {
        String query = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?,?)";

        String NIT = cliente.getNIT();
        String nombre = cliente.getNombre();
        String apellido = cliente.getApellido();
        int telefono = cliente.getTelefono();
        String DPI = cliente.getDPI();
        double credito = cliente.getCredito();
        double efectivo = cliente.getEfectivo();
        String direccion = cliente.getDireccion();
        String correoElectronico = cliente.getCorreoElectronico();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, NIT);
            preSt.setString(2, nombre);
            preSt.setString(3, apellido);
            preSt.setInt(4, telefono);
            preSt.setString(5, DPI);
            preSt.setDouble(6, credito);
            preSt.setDouble(7, efectivo);
            preSt.setString(8, direccion);
            preSt.setString(9, correoElectronico);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearVenta(Connection conexion, Venta venta) {
        String query = "INSERT INTO Venta(fecha,total,NIT_cliente,codigo_tienda) VALUES (?,?,?,?)";

        Date fechaVenta = venta.getFecha();
        double totalPago = venta.getTotal();
        String NITcliente = venta.getNITCliente();
        String codigo_tienda = venta.getCodigoTienda();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setDate(1, fechaVenta);
            preSt.setDouble(2, totalPago);
            preSt.setString(3, NITcliente);
            preSt.setString(4, codigo_tienda);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos de la venta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void crearPaqueteVenta(Connection conexion, PaqueteVenta paqueteV) {
        String query = "INSERT INTO Paquete_Venta (codigo_producto, cantidad, costo, id_venta) "
                + "VALUES (?,?,?,?)";

        String codigoProducto = paqueteV.getCodigoProducto();
        int cantidad = paqueteV.getCantidad();
        double total = paqueteV.getTotal();
        int idVenta = paqueteV.getIdPaqueteVenta();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigoProducto);
            preSt.setInt(2, cantidad);
            preSt.setDouble(3, total);
            preSt.setInt(4, idVenta);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos del paquete venta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    /**
     * Pedido del archivo de Texto
     *
     * @param conexion
     * @param pedido
     */
    public void crearPedidoTXT(Connection conexion, Pedido pedido) {
        String query = "INSERT INTO Pedido VALUES (?,?,?,?,?,?,?,?)";

        int idPedido = pedido.getIdPedido();
        Date fechaPedido = pedido.getFecha();
        double totalPago = pedido.getTotal();
        double anticipo = pedido.getAnticipo();
        String estadoPedido = pedido.getEstadoPedido();
        boolean pedidoAtrasado = pedido.getPedidoAtrasado();
        String NITcliente = pedido.getNITCliente();
        int idTiempo = pedido.getIdTiempo();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setInt(1, idPedido);
            preSt.setDate(2, fechaPedido);
            preSt.setDouble(3, totalPago);
            preSt.setDouble(4, anticipo);
            preSt.setString(5, estadoPedido);
            preSt.setBoolean(6, pedidoAtrasado);
            preSt.setString(7, NITcliente);
            preSt.setInt(8, idTiempo);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos del pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearPaquetePedido(Connection conexion, PaquetePedido paqueteP) {
        String query = "INSERT INTO Paquete_Pedido (codigo_producto, cantidad, costo, id_pedido) "
                + "VALUES (?,?,?,?)";

        String codigoProducto = paqueteP.getCodigoProducto();
        int cantidad = paqueteP.getCantidad();
        double total = paqueteP.getTotal();
        int idPedido = paqueteP.getIdPedido();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1, codigoProducto);
            preSt.setInt(2, cantidad);
            preSt.setDouble(3, total);
            preSt.setInt(4, idPedido);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos del paquete pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void crearRegistros(Connection conexion, Registro registro) {
        String query = "INSERT INTO Registro (fecha, codigo_empleado, codigo_tienda) "
                + "VALUES (?,?,?)";

        Date fechaRegistro = registro.getFechaRegistro();
        String codigoEmpleado = registro.getCodigoEmpleado();
        String codigoTienda = registro.getCodigoTienda();

        try (PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setDate(1, fechaRegistro);
            preSt.setString(2, codigoEmpleado);
            preSt.setString(3, codigoTienda);

            preSt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos del registro", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     *
     * Solo nos sirve capturar la suma los pedidos para agregar y crear un
     * pedido
     *
     * @param filasA
     * @return
     */
    private ArrayList<Double> totalPedidos(ArrayList<String> filasA) {

        ArrayList<Double> totalPedido = new ArrayList<>();
        String idPedidoAux = "";
        int auxApuntador = -1;

        for (int i = 0; i < filasA.size(); i++) {
            String[] linea = filasA.get(i).split(",");
            if (linea[0].equals("PEDIDO")) {
                if (idPedidoAux.equals(linea[1])) {
                    //Se agrega el valor del paquete nuevo y se suma al ya existente
                    double auxTemp = totalPedido.get(auxApuntador);
                    auxTemp += Double.parseDouble(linea[8]);
                    totalPedido.set(auxApuntador, auxTemp);
                } else {
                    totalPedido.add(Double.parseDouble(linea[8]));
                    idPedidoAux = linea[1];
                    auxApuntador++;
                }
            }
        }

        return totalPedido;
    }

}
