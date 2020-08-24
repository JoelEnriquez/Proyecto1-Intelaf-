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
    private int codigoPedido;
    
    public PaquetePedido(int idPaquetePedido, int codigoPedido, String idProducto,
            int cantidad, double total) {
        super(idProducto, cantidad, total);
        this.idPaquetePedido = idPaquetePedido;
        this.codigoPedido = codigoPedido;
    }
    
    public PaquetePedido(int codigoPedido, String idProducto,
            int cantidad, double total) {
        super(idProducto, cantidad, total);
        this.codigoPedido = codigoPedido;
    }
    

    public int getIdPaquetePedido() {
        return idPaquetePedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }
    
    public String querySignos(){
        if (idPaquetePedido>0) {
            return "?,?,?,?,?";
        }
        return "?,?,?,?";
    }

    
}
