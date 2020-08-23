/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompra;

import java.sql.Date;

/**
 *
 * @author joel
 */
public class Venta extends PeticionProducto{
    
    private int codigoVenta;
    private String codigoTienda;

    public Venta(Date fecha, String NITCliente, double total,
            int codigoVenta, String codigoTienda) {
        super(fecha, NITCliente, total);
        this.codigoVenta = codigoVenta;
        this.codigoTienda = codigoTienda; 
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }
    
    
    
    
}
