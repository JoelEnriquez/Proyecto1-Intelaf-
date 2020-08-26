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
public class Persona {
    
    protected String nombre;
    protected String apellido;
    protected String NIT;
    protected String correoElectronico;
    protected String direccion;
    protected String DPI;
    protected int telefono;

    public Persona(String nombre, String apellido, String NIT, String correoElectronico, String direccion, String DPI, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.NIT = NIT;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.DPI = DPI;
        this.telefono = telefono;
    }
    
    /**
     * Constructor minimo persona para empleado
     * @param nombre
     * @param correoElectronico
     * @param direccion
     * @param DPI
     * @param telefono 
     */
    public Persona(String nombre, String correoElectronico, String direccion, String DPI, int telefono) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.DPI = DPI;
        this.telefono = telefono;
    }
    
    /**
     * Constructor persona basico
     * @param nombre
     * @param telefono 
     */
    public Persona(String nombre, int telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDPI() {
        return DPI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    
    
    

    
}
