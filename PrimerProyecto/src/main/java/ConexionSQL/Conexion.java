/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

/**
 *
 * @author joel
 */
public class Conexion {
    
    private static final String URL="jdbc:mysql://localhost:3306/TALLER";
    String user;
    String password;

    public Conexion(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    
    
    
    
}
