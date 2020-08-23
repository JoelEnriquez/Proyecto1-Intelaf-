/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ConexionSQL.Conexion;
import ConexionSQL.Consultas;
import GUICliente.InicioCliente;
import GUIEmpleado.InicioEmpleado;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class PantallaInicio extends javax.swing.JFrame {

    private Connection conexionEmpleado;
    private Connection conexionCliente;
    private Consultas consultas;
    private boolean existenciaDatos = false;

    public PantallaInicio() {
        initComponents();
        iniciarConexionEmp();
        comprobarDatos();
    }

    private void iniciarConexionEmp() {
        Conexion conexion = new Conexion("empleado", "intelafemp");
        conexion.crearConexion();
        conexionEmpleado = conexion.getConnection();

        consultas = new Consultas(); //Se inicia el objeto consultas para comprobar datos luego
    }

    private void comprobarDatos() {
        if (consultas.contadorDatos(conexionEmpleado)>0) {
            existenciaDatos = true;
        }
        System.out.println(existenciaDatos);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vClientesButton = new javax.swing.JButton();
        vEmpleadosButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        fondoInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vClientesButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        vClientesButton.setText("Version Clientes");
        vClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vClientesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vClientesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 51));

        vEmpleadosButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        vEmpleadosButton.setText("Version Empleados");
        vEmpleadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vEmpleadosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(vEmpleadosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, 51));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puerta (1).png"))); // NOI18N
        closeButton.setToolTipText("SALIR");
        closeButton.setContentAreaFilled(false);
        closeButton.setPreferredSize(new java.awt.Dimension(100, 100));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, -1, -1));

        fondoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Intelaf_Fisico (1).jpg"))); // NOI18N
        getContentPane().add(fondoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void vEmpleadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vEmpleadosButtonActionPerformed
        if (existenciaDatos) {
            ElegirTiendaFecha elegirTF = new ElegirTiendaFecha(this, true, conexionEmpleado);
            elegirTF.setLocationRelativeTo(this);
            elegirTF.setVisible(true);
        } else {
            InicioEmpleado inicioE = new InicioEmpleado(this, existenciaDatos,consultas);
            inicioE.setVisible(true);
            inicioE.setLocationRelativeTo(this);
            this.setVisible(false);
        }
    }//GEN-LAST:event_vEmpleadosButtonActionPerformed

    private void vClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vClientesButtonActionPerformed
        if (existenciaDatos) {
            InicioCliente inicioC = new InicioCliente(this);
            inicioC.setVisible(true);
            inicioC.setLocationRelativeTo(this);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Se requiere subida de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_vClientesButtonActionPerformed

    public void setExistenciaDatos(boolean existenciaDatos) {
        this.existenciaDatos = existenciaDatos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel fondoInicio;
    private javax.swing.JButton vClientesButton;
    private javax.swing.JButton vEmpleadosButton;
    // End of variables declaration//GEN-END:variables
}
