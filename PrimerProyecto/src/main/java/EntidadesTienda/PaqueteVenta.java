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
public class PaqueteVenta extends Paquete{
    
    private int idPaqueteVenta;
    private int codigoVenta;

    public PaqueteVenta(int codigoVenta, String idProducto, int cantidad, double total) {
        super(idProducto, cantidad, total);
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public int getIdPaqueteVenta() {
        return idPaqueteVenta;
    }

    public void setIdPaqueteVenta(int idPaqueteVenta) {
        this.idPaqueteVenta = idPaqueteVenta;
    }
    
}
