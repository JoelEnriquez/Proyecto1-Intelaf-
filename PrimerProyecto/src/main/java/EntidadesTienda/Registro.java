/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesTienda;

import java.sql.Date;

/**
 *
 * @author joel
 */
public class Registro {
    
    private int codigoEmpleado;
    private String codigoTienda;
    private Date fechaRegistro;

    public Registro(int codigoEmpleado, String codigoTienda, Date fechaRegistro) {
        this.codigoEmpleado = codigoEmpleado;
        this.codigoTienda = codigoTienda;
        this.fechaRegistro = fechaRegistro;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    
   
}
