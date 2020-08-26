/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesPersona;

import java.sql.Date;

/**
 *
 * @author joel
 */
public class Registro {
    
    private Date fechaRegistro;
    private String codigoEmpleado;
    private String codigoTienda;

    public Registro(Date fechaRegistro, String codigoEmpleado, String codigoTienda) {
        this.fechaRegistro = fechaRegistro;
        this.codigoEmpleado = codigoEmpleado;
        this.codigoTienda = codigoTienda;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }
    
    
}
