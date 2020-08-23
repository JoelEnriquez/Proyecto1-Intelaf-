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
    protected String NIT;
    protected String correoElectronico;
    protected String direccion;
    protected int DPI;
    protected int telefono;

    public Persona(String nombre, String NIT, String correoElectronico, String direccion, int DPI, int telefono) {
        this.nombre = nombre;
        this.NIT = NIT;
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

    public String getCorreo_electronico() {
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

    public int getDPI() {
        return DPI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    
}
