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

    public boolean seRepite(String linea, ArrayList<String> pKeys) {
        this.pKeys = pKeys;
        String[] atributosEntidad = linea.split(",");//Se separa la linea del parametro

        for (int i = 0; i < pKeys.size(); i++) {
            String lineaComparar = pKeys.get(i);
            //Se descompone la linea para analizar del array list
            String[] atriLineaComparar = lineaComparar.split(",");

            if (atriLineaComparar[0].equals("TIENDA") && atributosEntidad[0].equals("TIENDA")) {
                if (repeticionCadenas(atributosEntidad[3], atriLineaComparar[3])) {
                    return true;
                }

            } else if (atriLineaComparar[0].equals("TIEMPO") && atributosEntidad[0].equals("TIEMPO")) {
                if (repeticionTiempos(atributosEntidad[1], atributosEntidad[2],
                        atriLineaComparar[1], atriLineaComparar[2])) {
                    return true;
                }

            } else if (atriLineaComparar[0].equals("PRODUCTO") && atributosEntidad[0].equals("PRODUCTO")) {
                if (repeticionProductos(atriLineaComparar[3], atriLineaComparar[6],
                        atributosEntidad[3], atributosEntidad[6])) {
                    return true;
                }
                
            } else if (atriLineaComparar[0].equals("EMPLEADO") && atributosEntidad[0].equals("EMPLEADO")) {
                if (repeticionCadenas(atributosEntidad[2], atriLineaComparar[2])) {
                    return true;
                }
                
            } else if (atriLineaComparar[0].equals("CLIENTE") && atributosEntidad[0].equals("CLIENTE")) {
                if (repeticionCadenas(atributosEntidad[2], atriLineaComparar[2])) {
                    return true;
                }
                
            } else if (atriLineaComparar[0].equals("PEDIDO") && atributosEntidad[0].equals("PEDIDO")) {
                if (repeticionPedido(atriLineaComparar[1], atriLineaComparar[6],
                        atributosEntidad[1], atributosEntidad[6])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean repeticionTiempos(String codigoT1Cade1, String codigoT2Cade1,
            String codigoT1Cade2, String codigoT2Cade2) {
        return (codigoT1Cade1.equals(codigoT1Cade2) && codigoT2Cade1.equals(codigoT2Cade2))
                || (codigoT1Cade1.equals(codigoT2Cade2) && codigoT2Cade1.equals(codigoT1Cade2));
    }

    private boolean repeticionProductos(String codeProC1, String codeTieC1, String codeProC2, String codeTieC2) {
        return codeProC1.equals(codeProC2) && codeTieC1.equals(codeTieC2);
    }
    
    private boolean repeticionPedido(String codigoP1C1, String codeTieC1,String codigoP2C2, String codeTieC2){
        return codigoP1C1.equals(codigoP2C2) && codeTieC1.equals(codeTieC2);
    }
    
    private boolean repeticionCadenas(String cadena1, String cadena2) {
        return cadena1.equals(cadena2);
    }

}
