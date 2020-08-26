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
public class PaquetePedido extends Paquete {
    
    private int idPaquetePedido;
    private int idPedido;
    
    public PaquetePedido(int idPedido, String codigoProducto, int cantidad, double costo) {
        super(codigoProducto, cantidad, costo);
        this.idPedido = idPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPaquetePedido() {
        return idPaquetePedido;
    }

    public void setIdPaquetePedido(int idPaquetePedido) {
        this.idPaquetePedido = idPaquetePedido;
    }

}
