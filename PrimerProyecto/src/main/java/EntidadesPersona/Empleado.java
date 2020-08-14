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
    
    private int codigo;
    
    public Empleado(String nombre, String NIT, String correoElectronico,
            String direccion, int DPI, int numeroTelefono, int codigo) {
        super(nombre, NIT, correoElectronico, direccion, DPI, numeroTelefono);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }  
    
}
