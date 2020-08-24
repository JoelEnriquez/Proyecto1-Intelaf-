/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalidaDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author joel
 */
public class AnalizadorInputFile {

    private ArrayList<String> filaAceptada;
    private ArrayList<String> filaDescartada;
    private AnalizadorPK analizadorPK;

    public AnalizadorInputFile() {
        filaAceptada = new ArrayList<>();
        filaDescartada = new ArrayList<>();
        analizadorPK = new AnalizadorPK();
    }

    public void leerTxt(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linea;//Donde se va a guardar la linea a analizar
            while ((linea = bufferedReader.readLine()) != null) {
                String[] atributosEntidad = linea.split(","); //Separamos los atributos por coma
                agregarLista(atributosEntidad, linea);
            }

            fileReader.close();
        } catch (IOException e) {
            e.getMessage();
        }

        for (int i = 0; i < filaDescartada.size(); i++) {
            System.out.println(filaDescartada.get(i));
        }
    }

    /**
     * Sirve para analizar cada una de los atributos que esten en la linea
     * actual Donde se analiza primero que tenga el numero de atributos con
     * length Sino hay error de separacion
     *
     * @param arrFila
     * @param fila
     */
    private void agregarLista(String[] arrFila, String fila) {
        switch (arrFila[0]) {
            case "TIENDA":               
                if (arrFila.length == 5) {
                    if (verificarTienda(arrFila)) {
                        //Se comprueba que no exista el codigo de tienda
                        if (analizadorPK.seRepite(fila, filaAceptada)) {
                            filaDescartada.add(fila);
                        }
                        else{
                            filaAceptada.add(fila);                            
                        }
                    } else {
                        filaDescartada.add(fila);
                    }
                } else {
                    filaDescartada.add(fila);
                }
                break;

            case "TIEMPO":
                if (arrFila.length == 4) {
                    if (verificarTiempo(arrFila)) {
                        if (analizadorPK.seRepite(fila, filaAceptada)) {
                            filaDescartada.add(fila);
                        }
                        else{
                        filaAceptada.add(fila);
                        }
                    }
                    else{
                        filaDescartada.add(fila);
                    }
                } else {
                    filaDescartada.add(fila);
                }
                break;

            case "PRODUCTO":
                if (arrFila.length == 7) {
                    if (verificarProducto(arrFila)) {
                        if (analizadorPK.seRepite(fila, filaAceptada)) {
                            filaDescartada.add(fila);
                        }
                        else{
                        filaAceptada.add(fila);
                        }
                    } else {
                        filaDescartada.add(fila);
                    }
                } else {
                    filaDescartada.add(fila);
                }
                break;

            case "EMPLEADO":
                if (arrFila.length == 5) {
                    if (verificarEmpleado(arrFila)) {
                        if (analizadorPK.seRepite(fila, filaAceptada)) {
                            filaDescartada.add(fila);
                        }
                        else{
                        filaAceptada.add(fila);
                        }
                    } else {
                        filaDescartada.add(fila);
                    }
                } else {
                    filaDescartada.add(fila);
                }
                break;

            case "CLIENTE":
                if (arrFila.length == 5) {
                    if (verificarCliente(arrFila)) {
                        if (analizadorPK.seRepite(fila, filaAceptada)) {
                            filaDescartada.add(fila);
                        }
                        else{
                        filaAceptada.add(fila);
                        }
                    } else {
                        filaDescartada.add(fila);
                    }
                } else {
                    filaDescartada.add(fila);
                }
                break;

            case "PEDIDO":
                if (arrFila.length == 10) {
                    if (verificarPedido(arrFila)) {
                        if (analizadorPK.seRepite(fila, filaAceptada)) {
                            filaDescartada.add(fila);
                        }
                        else{
                        filaAceptada.add(fila);
                        }
                    } else {
                        filaDescartada.add(fila);
                    }
                } else {
                    filaDescartada.add(fila);
                }
                break;
            default:
                filaDescartada.add(fila);
                break;
        }
    }

    private boolean verificarTienda(String[] arrTienda) {
        if (nombreMixto(arrTienda[1])) {
            if (esTexto(arrTienda[2])) {
                if (esCodigo(arrTienda[3])) {
                    if (sonEnteros(arrTienda[4])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verificarTiempo(String[] arrTiempo) {
        if (esCodigo(arrTiempo[1])) {
            if (esCodigo(arrTiempo[2])) {
                if (sonEnteros(arrTiempo[3])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verificarProducto(String[] arrProducto) {
        if (nombreMixto(arrProducto[1])) {
            if (esTexto(arrProducto[2])) {
                if (esCodigo(arrProducto[3])) {
                    if (sonEnteros(arrProducto[4])) {
                        if (sonDecimales(arrProducto[5])) {
                            if (esCodigo(arrProducto[6])) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean verificarEmpleado(String[] arrEmpleado) {
        if (nombreMixto(arrEmpleado[1])) {
            if (sonEnteros(arrEmpleado[2])) {
                if (sonEnteros(arrEmpleado[3])) {
                    if (sonNumeros(arrEmpleado[4])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verificarCliente(String[] arrCliente) {
        if (esTexto(arrCliente[1])) {
            if (esCodigo(arrCliente[2])) {
                if (sonEnteros(arrCliente[3])) {
                    if (sonEnteros(arrCliente[4])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verificarPedido(String[] arrPedido) {
        if (sonEnteros(arrPedido[1])) {
            if (esCodigo(arrPedido[2])) {
                if (esCodigo(arrPedido[3])) {
                    if (esFecha(arrPedido[4])) {
                        if (esCodigo(arrPedido[5])) {
                            if (esCodigo(arrPedido[6])) {
                                if (sonEnteros(arrPedido[7])) {
                                    if (sonDecimales(arrPedido[8])) {
                                        if (sonNumeros(arrPedido[9])) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean esTexto(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isLetter(texto.charAt(i)) && !(texto.charAt(i) == ' ')) {
                return false;
            }
        }
        return true;
    }

    private boolean esCodigo(String codigo) {
        String[] atributosCodigo = codigo.split("-");
        if (atributosCodigo.length == 2) {
            return esTexto(atributosCodigo[0]) && sonEnteros(atributosCodigo[1]);
        }
        return false;
    }

    private boolean sonEnteros(String numeros) {
        for (int i = 0; i < numeros.length(); i++) {
            if (!Character.isDigit(numeros.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean sonDecimales(String decimales) {
        String[] atributosDecimal = decimales.split(Pattern.quote("."));
        if (atributosDecimal.length == 2) {
            return sonEnteros(atributosDecimal[0]) && sonEnteros(atributosDecimal[1]);
        }
        return false;
    }

    private boolean esFecha(String fecha) {
        String[] atributosFecha = fecha.split("-");
        if (atributosFecha.length == 3) {
            return sonEnteros(atributosFecha[0]) && sonEnteros(atributosFecha[1])
                    && sonEnteros(atributosFecha[2]);
        }
        return false;
    }

    private boolean nombreMixto(String nombreM) {
        for (int i = 0; i < nombreM.length(); i++) {
            if (!Character.isDigit(nombreM.charAt(i)) && !Character.isLetter(nombreM.charAt(i))
                    && !(nombreM.charAt(i) == ' ')) {
                return false;
            }
        }
        return true;
    }

    private boolean sonNumeros(String numeros) {
        return sonEnteros(numeros) || sonDecimales(numeros);
    }

    public ArrayList<String> getFilaAceptada() {
        return filaAceptada;
    }

    public ArrayList<String> getFilaDescartada() {
        return filaDescartada;
    }
}
