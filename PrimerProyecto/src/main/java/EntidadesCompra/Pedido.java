/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompra;

import java.sql.Date;
import java.util.Random;

/**
 *
 * @author joel
 */
public class Pedido extends PeticionProducto{
    
    private int idPedido;
    private int idTiempo;
    private double anticipo;
    private String estadoPedido;
    private boolean pedidoAtrasado;

    public Pedido(Date fecha, String NITCliente, double total, double anticipo,
            int idPedido,int idTiempo) {
        super(fecha, NITCliente, total);
        this.anticipo = anticipo;
        this.idPedido = idPedido;
        this.idTiempo = idTiempo;
        estadoPedido = "En curso";
        
        definirPedidoAtrasado();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public boolean getPedidoAtrasado() {
        return pedidoAtrasado;
    }

    public void setPedidoAtrasado(boolean pedidoAtrasado) {
        this.pedidoAtrasado = pedidoAtrasado;
    }
    
    /**
     * Se define si el pedido va a llegar atrasado o no
     */
    private void definirPedidoAtrasado(){
        Random r = new Random();
        int valorDado = r.nextInt(100)+1;
        
        pedidoAtrasado = valorDado > 75; 
    }
 
    
}
