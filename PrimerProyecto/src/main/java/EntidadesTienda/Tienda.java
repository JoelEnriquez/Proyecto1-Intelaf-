/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesTienda;

import EntidadesCompra.*;
import EntidadesPersona.Empleado;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class Tienda {
    
    //private ArrayList<Pedido> listaPedidos;
    //private ArrayList<Venta> listaVentas;
    //private ArrayList<Producto> listaProductos;
    //private ArrayList<Pedido> listaClientes;
    //private ArrayList<Empleado> listaEmpleados;
    
    private String nombre;
    private String direccion;
    private String codigo;
    private int telefono1;
    private int telefono2;
    private String correoElectronico;
    private String horario;

    /**
     * Constructor obligatorio de dichos atributos
     * @param nombre
     * @param direccion
     * @param codigo
     * @param telefono1 
     */
    public Tienda(String nombre, String direccion, String codigo, int telefono1) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo = codigo;
        this.telefono1 = telefono1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
    
}
