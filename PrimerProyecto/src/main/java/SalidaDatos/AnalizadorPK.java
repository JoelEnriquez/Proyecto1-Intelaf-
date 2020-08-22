/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalidaDatos;

import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class AnalizadorPK {
    private String palabraComparar;
    private ArrayList<String> pKeys;

    public boolean seRepite(String linea, ArrayList<String> pKeys,String nombreEntidad){
        this.pKeys = pKeys;
        String[] atributosEntidad = linea.split(",");//Se separa la linea por parametro
        
        for (int i = 0; i < pKeys.size(); i++) {
            String lineaComparar = pKeys.get(i);
            //Se descompone la linea para analizar
            String[] atriLineaComparar = lineaComparar.split(",");
            
            switch (atriLineaComparar[0]) {
                case "TIENDA":
                    if (repeticionCadenas(atributosEntidad[3], atriLineaComparar[3])) {
                        return true;
                    }
                    break;
                case "TIEMPO":
                    if (repeticionTiempos(atributosEntidad[1],atributosEntidad[2],
                    atriLineaComparar[1],atriLineaComparar[2])) {
                        return true;
                    }
                    break;
                case "PRODUCTO":
                    if (repeticionCadenas(atributosEntidad[3], atriLineaComparar[3])) {
                        return true;
                    }
                    break;
                case "EMPLEADO":
                    if (repeticionCadenas(atributosEntidad[2], atriLineaComparar[2])) {
                        return true;
                    }
                    break;
                case "CLIENTE":
                    if (repeticionCadenas(atributosEntidad[2], atriLineaComparar[2])) {
                        return true;
                    }
                    break;
                case "PEDIDO":
                    if (repeticionCadenas(atributosEntidad[1], atriLineaComparar[1])) {
                        return true;
                    }
                    break;
                default:
                    break;
            }            
        }
        return false;
    }
    
    private boolean repeticionTiempos(String codigoT1Cade1, String codigoT2Cade1,
            String codigoT1Cade2, String codigoT2Cade2){
        return codigoT1Cade1.equals(codigoT1Cade2) && codigoT2Cade1.equals(codigoT2Cade2);
    }
    
    private boolean repeticionCadenas(String cadena1, String cadena2){
        return cadena1.equals(cadena2);
    }
    
    
}
