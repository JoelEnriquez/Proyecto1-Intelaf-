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
public class Cliente extends Persona {
    
    private double credito;
    private double efectivo;
    
    /**
     * Constructor completo para crear personas
     * @param nombre
     * @param apellido
     * @param NIT
     * @param correoElectronico
     * @param direccion
     * @param DPI
     * @param telefono
     * @param credito
     * @param efectivo 
     */
    public Cliente(String nombre,String apellido, String NIT, String correoElectronico,
            String direccion, String DPI, int telefono, double credito, double efectivo) {
        super(nombre,apellido, NIT, correoElectronico, direccion, DPI, telefono);
        this.credito = credito;
        this.efectivo = efectivo;
    }
    
    /**
     * Constructor entrada de texto
     * @param nombre
     * @param NIT
     * @param telefono
     * @param credito 
     */
    public Cliente(String nombre, String NIT, int telefono, double credito){
        super(nombre, telefono);
        super.NIT = NIT;
        this.credito = credito;
    }
    
    /**
     * Constructor minimo e obligatorio
     * @param nombre
     * @param telefono
     * @param NIT 
     */
    public Cliente(String nombre, int telefono, String NIT){
        super(nombre, telefono);
        super.NIT = NIT;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

}
