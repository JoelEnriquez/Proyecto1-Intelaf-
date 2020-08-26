
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
public class PaqueteVenta extends Paquete{
    
    private int idPaqueteVenta;
    private int idVenta;
    
    public PaqueteVenta(int idVenta, String codigoProducto, int cantidad, double costo) {
        super(codigoProducto, cantidad, costo);
        this.idVenta = idVenta;
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdPaqueteVenta() {
        return idPaqueteVenta;
    }

    public void setIdPaqueteVenta(int idPaqueteVenta) {
        this.idPaqueteVenta = idPaqueteVenta;
    }
    
    
    
    
}
