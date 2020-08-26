/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIConsultas;

import ConexionSQL.InfoInicial;
import ConexionSQL.InsertarData;
import EntidadesTienda.Tiempo;
import GUIEmpleado.InicioEmpleado;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class TiempoEntreTiendas extends javax.swing.JDialog {

    private InicioEmpleado inicioE;
    private String codigoTienda;
    private ArrayList<String> nombreTiendas;
    private InfoInicial infoI;
    private Connection conexion;
    private InsertarData insertarD;
    private int auxTamaño;
    
    
    
    public TiempoEntreTiendas(InicioEmpleado inicioE, boolean modal, Connection conexion) {
        super(inicioE, modal);
        initComponents();
        this.inicioE= inicioE;
        this.conexion = conexion;
        insertarD = new InsertarData();
        infoI = new InfoInicial();
        
        
    }
    
    public TiempoEntreTiendas(InicioEmpleado inicioE, boolean modal, String codigoTienda, Connection conexion) {
        super(inicioE, modal);
        initComponents();
        this.inicioE= inicioE;
        this.codigoTienda =codigoTienda;
        this.conexion = conexion;
        insertarD = new InsertarData();
        infoI = new InfoInicial();
        
        desactivarElementos();
        
        tiendaActual.setText(codigoTienda);
    }
    
    public void agregarTiendasCombo(){
        
        nombreTiendas = infoI.getCodigoTiendas(conexion);
        
        for (int i = 0; i < nombreTiendas.size(); i++) {
            listaTiendas.addItem(nombreTiendas.get(i));
        }

        auxTamaño = nombreTiendas.size();
        
        closeButton.setEnabled(false); //No permitimos que salga el usuario
    }
    
    private void desactivarElementos(){
        listarTiemposButton.setEnabled(false);
        tiendaModificarTF.setEnabled(false);
        modificarButton.setEnabled(false);
        closeButton.setEnabled(false);
    }
    
    private void activarElementos(){
        listarTiemposButton.setEnabled(true);
        tiendaModificarTF.setEnabled(true);
        modificarButton.setEnabled(true);
        closeButton.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        tiendaActual = new javax.swing.JTextField();
        listaTiendas = new javax.swing.JComboBox<>();
        tiempotxt = new javax.swing.JLabel();
        ScrollTiempos = new javax.swing.JScrollPane();
        tablaTiempos = new javax.swing.JTable();
        agregarButton = new javax.swing.JButton();
        listarTiemposButton = new javax.swing.JButton();
        tiempoJSpinner = new javax.swing.JSpinner();
        modificarButton = new javax.swing.JButton();
        tiendaModificarTF = new javax.swing.JTextField();
        tiendaModificartxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar (1).png"))); // NOI18N
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        tiendaActual.setEditable(false);
        tiendaActual.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        listaTiendas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        tiempotxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tiempotxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiempotxt.setText("Tiempo");

        tablaTiempos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollTiempos.setViewportView(tablaTiempos);

        agregarButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        listarTiemposButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        listarTiemposButton.setText("Mostrar los Tiempos");
        listarTiemposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarTiemposButtonActionPerformed(evt);
            }
        });

        tiempoJSpinner.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tiempoJSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));

        modificarButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        modificarButton.setText("Modificar");

        tiendaModificartxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tiendaModificartxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiendaModificartxt.setText("Tienda Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tiendaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(listaTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tiempotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 103, Short.MAX_VALUE)
                                .addComponent(tiempoJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modificarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiendaModificarTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiendaModificartxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listarTiemposButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tiempotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiendaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoJSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(ScrollTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listarTiemposButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(tiendaModificartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiendaModificarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        try {
            int tiempoTiendas = (Integer)tiempoJSpinner.getValue();
            String codigoT2 = listaTiendas.getSelectedItem().toString();
            
            Tiempo tiempo = new Tiempo(codigoTienda, codigoT2, tiempoTiendas);
            insertarD.crearTiempo(conexion, tiempo);
            
            if (listaTiendas.getSelectedIndex()>-1) {
               nombreTiendas.remove(listaTiendas.getSelectedIndex());
               
               listaTiendas.removeAllItems();
                for (int i = 0; i < nombreTiendas.size(); i++) {
                    listaTiendas.addItem(nombreTiendas.get(i));
                }
            }
            auxTamaño--;
            
            if (auxTamaño==0) {
                JOptionPane.showMessageDialog(this, "Se han ingresado todos los tiempos", "Nice", JOptionPane.INFORMATION_MESSAGE);
                activarElementos();
                agregarButton.setEnabled(false);
                closeButton.setEnabled(true);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear el nuevo tiempo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void listarTiemposButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTiemposButtonActionPerformed
        
    }//GEN-LAST:event_listarTiemposButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollTiempos;
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> listaTiendas;
    private javax.swing.JButton listarTiemposButton;
    private javax.swing.JButton modificarButton;
    private javax.swing.JTable tablaTiempos;
    private javax.swing.JSpinner tiempoJSpinner;
    private javax.swing.JLabel tiempotxt;
    private javax.swing.JTextField tiendaActual;
    private javax.swing.JTextField tiendaModificarTF;
    private javax.swing.JLabel tiendaModificartxt;
    // End of variables declaration//GEN-END:variables
}