/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompra;

import java.sql.Date;


public class PeticionProducto {
    
    protected Date fecha;
    protected String NITCliente;
    protected double total;
    

    public PeticionProducto(Date fecha, String NITCliente, double total) {
        this.fecha = fecha;
        this.NITCliente = NITCliente;
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNITCliente() {
        return NITCliente;
    }

    public void setNITCliente(String NITCliente) {
        this.NITCliente = NITCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }



    
    
}
