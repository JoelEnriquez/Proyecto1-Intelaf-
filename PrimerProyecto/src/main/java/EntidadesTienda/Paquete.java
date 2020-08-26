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
public class Paquete {
    
    protected String codigoProducto;
    protected int cantidad;
    protected double total;

    public Paquete(String codigoProducto, int cantidad, double total) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }
    
    
}
