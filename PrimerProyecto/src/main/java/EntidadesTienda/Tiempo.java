/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesTienda;

/**
 *
 * @author joel
 */
public class Tiempo {
    
    private int idTiempo;
    private String codigoTienda1;
    private String codigoTienda2;
    private int tiempoTiendas;

    public Tiempo(String codigoTienda1, String codigoTienda2, int tiempoTiendas) {
        this.codigoTienda1 = codigoTienda1;
        this.codigoTienda2 = codigoTienda2;
        this.tiempoTiendas = tiempoTiendas;
    }

    public String getCodigoTienda1() {
        return codigoTienda1;
    }

    public String getCodigoTienda2() {
        return codigoTienda2;
    }

    public int getTiempoTiendas() {
        return tiempoTiendas;
    }

    public void setTiempoTiendas(int tiempoTiendas) {
        this.tiempoTiendas = tiempoTiendas;
    }

    public int getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }
    
    

    
}
