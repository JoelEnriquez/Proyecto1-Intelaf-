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
    
    public Cliente(String nombre, String NIT, String correoElectronico,
            String direccion, int DPI, int numeroTelefono, double credito, double efectivo) {
        super(nombre, NIT, correoElectronico, direccion, DPI, numeroTelefono);
        this.credito = credito;
        this.efectivo = efectivo;
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
