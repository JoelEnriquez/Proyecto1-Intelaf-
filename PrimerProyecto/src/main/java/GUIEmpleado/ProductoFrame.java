/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmpleado;

import ConexionSQL.InsertarData;
import GUIConsultas.ModificarOVerProducto;
import java.sql.Connection;

/**
 *
 * @author joel
 */
public class ProductoFrame extends javax.swing.JFrame {

    private InicioEmpleado inicioE;
    private InsertarData insertarD;
    private Connection conexion;
    
    public ProductoFrame(InicioEmpleado inicioE,InsertarData insertarD,Connection conexion) {
        initComponents();
        this.inicioE = inicioE;
        this.insertarD = insertarD;
        this.conexion = conexion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        crearProducto = new javax.swing.JButton();
        mostrarProductos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(615, 630));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izquierda (1).png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, 90, 90));

        crearProducto.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        crearProducto.setText("Crear Producto");
        crearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProductoActionPerformed(evt);
            }
        });
        getContentPane().add(crearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 310, 90));

        mostrarProductos.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        mostrarProductos.setText("Mostrar Productos");
        mostrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarProductosActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 360, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productoTienda.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        inicioE.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void mostrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarProductosActionPerformed
        ModificarOVerProducto modiOVer = new ModificarOVerProducto(this, true, insertarD, conexion, inicioE);
        modiOVer.setLocationRelativeTo(this);
        modiOVer.setVisible(true);
    }//GEN-LAST:event_mostrarProductosActionPerformed

    private void crearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProductoActionPerformed
        AgregarProducto agregarP = new AgregarProducto(this, true, insertarD, conexion, inicioE);
        agregarP.setLocationRelativeTo(this);
        agregarP.setVisible(true);
        
    }//GEN-LAST:event_crearProductoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton crearProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mostrarProductos;
    // End of variables declaration//GEN-END:variables
}
