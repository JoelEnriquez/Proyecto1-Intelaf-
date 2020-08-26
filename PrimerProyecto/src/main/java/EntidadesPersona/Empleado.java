/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesPersona;

/**
 *
 * @author joel
 */
public class Empleado extends Persona {
    
    private String codigoEmpleado;

    /**
     * Constructor completo para crear empleados
     * @param nombre
     * @param apellido
     * @param NIT
     * @param correoElectronico
     * @param direccion
     * @param DPI
     * @param telefono
     * @param codigoEmpleado 
     */
    public Empleado(String nombre,String apellido, String NIT, String correoElectronico,
            String direccion, String DPI, int telefono, String codigoEmpleado) {
        super(nombre,apellido, NIT, correoElectronico, direccion, DPI, telefono);
        this.codigoEmpleado=codigoEmpleado;
    }
    
    /**
     * Constructor minimo para crear nuevos Empleados
     * @param nombre
     * @param correoElectronico
     * @param direccion
     * @param DPI
     * @param telefono 
     * @param codigoEmpleado 
     */
    public Empleado(String nombre, String correoElectronico,
            String direccion, String DPI, int telefono, String codigoEmpleado) {
        super(nombre, correoElectronico, direccion, DPI, telefono);
        this.codigoEmpleado=codigoEmpleado;
    }
    
    /**
     * Constructor entrada txt
     * @param nombre
     * @param codigoEmpleado
     * @param telefono
     * @param DPI 
     */
    public Empleado(String nombre, String codigoEmpleado, int telefono, String DPI){
        super(nombre,telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.DPI = DPI;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }  
    
}
