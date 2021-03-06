/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmpleado;

import ConexionSQL.Consultas;
import ConexionSQL.InsertarData;
import java.sql.Connection;

/**
 *
 * @author joel
 */
public class Usuarios extends javax.swing.JFrame {

    InicioEmpleado inicioEmpleado;
    Connection conexion;
    InsertarData insertarD;
    Consultas consultas;
    
    
    public Usuarios(InicioEmpleado inicioEmpleado, Connection conexion, InsertarData insertarD,
            Consultas consultas) {
        initComponents();
        this.inicioEmpleado = inicioEmpleado;
        this.conexion = conexion;
        this.insertarD = insertarD;
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

        crearClienteButton = new javax.swing.JButton();
        modificarClienteButton = new javax.swing.JButton();
        crearEmpleadoButton = new javax.swing.JButton();
        modificarEmpleadoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cliente_empleadofondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearClienteButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        crearClienteButton.setText("Crear Cliente");
        getContentPane().add(crearClienteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 230, 70));

        modificarClienteButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        modificarClienteButton.setText("Modificar Cliente");
        modificarClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarClienteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(modificarClienteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 230, 80));

        crearEmpleadoButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        crearEmpleadoButton.setText("Crear Empleado");
        crearEmpleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEmpleadoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(crearEmpleadoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 270, 70));

        modificarEmpleadoButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        modificarEmpleadoButton.setText("Modificar Empleado");
        getContentPane().add(modificarEmpleadoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 270, 80));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Empleado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 190, 60));

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok.png"))); // NOI18N
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 410, 100, 100));

        cliente_empleadofondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clientes&Empleado.jpg"))); // NOI18N
        cliente_empleadofondo.setPreferredSize(new java.awt.Dimension(1450, 604));
        getContentPane().add(cliente_empleadofondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 800, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.setVisible(false);
        inicioEmpleado.setVisible(true);
    }//GEN-LAST:event_okButtonActionPerformed

    private void crearEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEmpleadoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmpleadoButtonActionPerformed

    private void modificarClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarClienteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarClienteButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cliente_empleadofondo;
    private javax.swing.JButton crearClienteButton;
    private javax.swing.JButton crearEmpleadoButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton modificarClienteButton;
    private javax.swing.JButton modificarEmpleadoButton;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
