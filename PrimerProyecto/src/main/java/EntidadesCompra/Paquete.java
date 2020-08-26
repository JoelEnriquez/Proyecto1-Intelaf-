/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompra;

/**
 *
 * @author joel
 */
public class Paquete {
    
    protected String codigoProducto;
    private int cantidad;
    private double costo;

    public Paquete(String codigoProducto, int cantidad, double costo) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCosto() {
        return costo;
    }
    
    
}
