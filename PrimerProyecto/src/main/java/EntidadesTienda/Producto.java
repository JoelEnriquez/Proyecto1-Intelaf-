/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesTienda;

/**
 *
 * @author joel
 */
public class Producto {
    
    private String nombre;
    private String fabricante;
    private String descripcion;
    private String codigo;
    private double precio;
    private String garantia;

    /**
     * Constructor archivo txt
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param precio 
     */
    public Producto(String nombre, String fabricante, String codigo, double precio) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.precio = precio;
    }

    public Producto(String nombre, String fabricante, String descripcion, String codigo, double precio, String garantia) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
        this.garantia = garantia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    
}
