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
public class Pedido extends PeticionProducto{
    
    private int codigoPedido;
    private String codigoTienda1;
    private String codigoTienda2;
    private int idTiempo;

    public Pedido(Date fecha, String NITCliente, double total, double anticipo,
            int codigoPedido, String codigoTienda1, String codigoTienda2, int idTiempo) {
        super(fecha, NITCliente, total, anticipo);
        this.codigoPedido = codigoPedido;
        this.codigoTienda1 = codigoTienda1;
        this.codigoTienda2 = codigoTienda2;
        this.idTiempo = idTiempo;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCodigoTienda1() {
        return codigoTienda1;
    }

    public void setCodigoTienda1(String codigoTienda1) {
        this.codigoTienda1 = codigoTienda1;
    }

    public String getCodigoTienda2() {
        return codigoTienda2;
    }

    public void setCodigoTienda2(String codigoTienda2) {
        this.codigoTienda2 = codigoTienda2;
    }

    public int getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }
    
    
    
    
}
