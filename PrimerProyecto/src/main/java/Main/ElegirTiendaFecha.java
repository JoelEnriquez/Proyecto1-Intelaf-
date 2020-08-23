/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;

/**
 *
 * @author joel
 */
public class ElegirTiendaFecha extends javax.swing.JDialog {

    private PantallaInicio pantallaInicio;
    private Connection conexionE;
    
    /**
     * Creates new form ElegirTienda
     * @param pantallaInicio
     * @param modal
     * @param conexionE
     */
    public ElegirTiendaFecha(PantallaInicio pantallaInicio, boolean modal, Connection conexionE) {
        super(pantallaInicio, modal);
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.conexionE = conexionE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigoTienda = new javax.swing.JLabel();
        listaCodeTiendasCombo = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        txtElegirFecha = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoTienda.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        txtCodigoTienda.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCodigoTienda.setText("Codigo Tienda");
        getContentPane().add(txtCodigoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 220, 40));

        listaCodeTiendasCombo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(listaCodeTiendasCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 230, 60));

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/okay (85).png"))); // NOI18N
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 85, 85));

        txtElegirFecha.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        txtElegirFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtElegirFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtElegirFecha.setText("Elegir Fecha");
        getContentPane().add(txtElegirFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, 40));

        dateChooser.setDateFormatString("yyyy-MMM-dd");
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 220, 60));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda (400px).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 465));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listaCodeTiendasCombo;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel txtCodigoTienda;
    private javax.swing.JLabel txtElegirFecha;
    // End of variables declaration//GEN-END:variables
}