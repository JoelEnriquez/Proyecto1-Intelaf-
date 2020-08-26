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
public class Bodega {
    
    private String codigoTienda;
    private String codigoProducto;
    private int cantidadProducto;

    public Bodega(String codigoTienda, String codigoProducto, int cantidadProducto) {
        this.codigoTienda = codigoTienda;
        this.codigoProducto = codigoProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    
    
}
