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
public class PaquetePedido extends Paquete{
    
    private int idPaquetePedido;
    private int idPedido;
    
    public PaquetePedido(int idPedido, String idProducto,
            int cantidad, double total) {
        super(idProducto, cantidad, total);
        this.idPedido = idPedido;
    }  

    public int getIdPaquetePedido() {
        return idPaquetePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    
}
