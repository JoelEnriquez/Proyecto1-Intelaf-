/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmpleado;

import ConexionSQL.Consultas;
import java.sql.Connection;

/**
 *
 * @author joel
 */
public class Pedidos extends javax.swing.JFrame {

    private InicioEmpleado inicioE;
    private Connection conexion;
    private Consultas consultas;
    

    /**
     * Creates new form Pedidos
     * @param inicioE
     * @param conexion
     * @param consultas
     */
    public Pedidos(InicioEmpleado inicioE, Connection conexion, Consultas consultas) {
        initComponents();
        this.inicioE = inicioE;
        this.conexion = conexion;
        this.consultas = consultas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encargarPedidoButton = new javax.swing.JButton();
        registrarPedidosButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        llegaranTiendaButton = new javax.swing.JButton();
        pedidosRegistrarButton = new javax.swing.JButton();
        pedidosRetrasadosButton = new javax.swing.JButton();
        pedidosOtrasTiendasButton = new javax.swing.JButton();
        pedidosCursoClienteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        carritoCompraFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encargarPedidoButton.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        encargarPedidoButton.setText("Encargar Pedido");
        getContentPane().add(encargarPedidoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 60));

        registrarPedidosButton.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        registrarPedidosButton.setText("Registrar Pedidos");
        getContentPane().add(registrarPedidosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 220, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reportes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 160, 60));

        llegaranTiendaButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        llegaranTiendaButton.setText("Llegaran a tienda");
        llegaranTiendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llegaranTiendaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(llegaranTiendaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 170, 50));

        pedidosRegistrarButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        pedidosRegistrarButton.setText("Pedidos en tienda para registrar");
        pedidosRegistrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosRegistrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pedidosRegistrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 280, 50));

        pedidosRetrasadosButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        pedidosRetrasadosButton.setText("Vienen retrasados");
        pedidosRetrasadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosRetrasadosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pedidosRetrasadosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 170, 50));

        pedidosOtrasTiendasButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        pedidosOtrasTiendasButton.setText("Van a llegar a otra tienda");
        pedidosOtrasTiendasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosOtrasTiendasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pedidosOtrasTiendasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 280, 50));

        pedidosCursoClienteButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        pedidosCursoClienteButton.setText("Pedidos en curso de cliente");
        pedidosCursoClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosCursoClienteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pedidosCursoClienteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 250, 50));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izquierda (1).png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 90, 90));

        carritoCompraFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermercado.png"))); // NOI18N
        getContentPane().add(carritoCompraFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llegaranTiendaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llegaranTiendaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_llegaranTiendaButtonActionPerformed

    private void pedidosRegistrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosRegistrarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosRegistrarButtonActionPerformed

    private void pedidosRetrasadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosRetrasadosButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosRetrasadosButtonActionPerformed

    private void pedidosOtrasTiendasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosOtrasTiendasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosOtrasTiendasButtonActionPerformed

    private void pedidosCursoClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosCursoClienteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosCursoClienteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        inicioE.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel carritoCompraFondo;
    private javax.swing.JButton encargarPedidoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton llegaranTiendaButton;
    private javax.swing.JButton pedidosCursoClienteButton;
    private javax.swing.JButton pedidosOtrasTiendasButton;
    private javax.swing.JButton pedidosRegistrarButton;
    private javax.swing.JButton pedidosRetrasadosButton;
    private javax.swing.JButton registrarPedidosButton;
    // End of variables declaration//GEN-END:variables
}
