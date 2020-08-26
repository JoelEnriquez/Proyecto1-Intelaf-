/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmpleado;

import ConexionSQL.InfoInicial;
import ConexionSQL.InsertarData;
import EntidadesTienda.Bodega;
import EntidadesTienda.Producto;
import Logica.Constantes;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class AgregarProducto extends javax.swing.JDialog {

    private ProductoFrame productoF;
    private InsertarData insertarD;
    private Connection conexion;
    private Constantes constantes;
    private ArrayList<String> nombreTiendas;
    private InicioEmpleado inicioE;
    /**
     * Creates new form AgregarTienda
     * @param productoF
     * @param modal
     * @param insertarD
     * @param conexion
     * @param inicioE
     */
    public AgregarProducto(ProductoFrame productoF, boolean modal,InsertarData insertarD,
            Connection conexion, InicioEmpleado inicioE) {
        super(productoF, modal);
        initComponents();
        this.productoF = productoF;
        this.insertarD = insertarD;
        this.conexion = conexion;
        this.inicioE = inicioE;
    }
    
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        nombreTextF = new javax.swing.JTextField();
        fabricantetxt = new javax.swing.JLabel();
        nombretxt = new javax.swing.JLabel();
        fabricanteTF = new javax.swing.JTextField();
        codigoTF = new javax.swing.JTextField();
        cantidadtxt = new javax.swing.JLabel();
        codigotxt = new javax.swing.JLabel();
        garantiatxt = new javax.swing.JLabel();
        preciotxt = new javax.swing.JLabel();
        descripciontxt = new javax.swing.JLabel();
        descripcionTF = new javax.swing.JTextField();
        cantidadJs = new javax.swing.JSpinner();
        precioJs = new javax.swing.JSpinner();
        garantiaJs = new javax.swing.JSpinner();
        fondoTienda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(627, 585));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok.png"))); // NOI18N
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 100, 100));

        nombreTextF.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        nombreTextF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFActionPerformed(evt);
            }
        });
        nombreTextF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTextFKeyTyped(evt);
            }
        });
        getContentPane().add(nombreTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 190, 52));

        fabricantetxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        fabricantetxt.setForeground(new java.awt.Color(0, 0, 0));
        fabricantetxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fabricantetxt.setText("Fabricante");
        getContentPane().add(fabricantetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 164, 21));

        nombretxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(0, 0, 0));
        nombretxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombretxt.setText("Nombre");
        getContentPane().add(nombretxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 164, 21));

        fabricanteTF.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        fabricanteTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fabricanteTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fabricanteTFKeyTyped(evt);
            }
        });
        getContentPane().add(fabricanteTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, 52));

        codigoTF.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        codigoTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTFActionPerformed(evt);
            }
        });
        codigoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoTFKeyTyped(evt);
            }
        });
        getContentPane().add(codigoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 190, 52));

        cantidadtxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cantidadtxt.setForeground(new java.awt.Color(0, 0, 0));
        cantidadtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantidadtxt.setText("Cantidad");
        getContentPane().add(cantidadtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 164, 21));

        codigotxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        codigotxt.setForeground(new java.awt.Color(0, 0, 0));
        codigotxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigotxt.setText("Codigo");
        getContentPane().add(codigotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 216, -1));

        garantiatxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        garantiatxt.setForeground(new java.awt.Color(0, 0, 0));
        garantiatxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garantiatxt.setText("Garantia");
        getContentPane().add(garantiatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 210, 21));

        preciotxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        preciotxt.setForeground(new java.awt.Color(0, 0, 0));
        preciotxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preciotxt.setText("Precio");
        getContentPane().add(preciotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 210, 21));

        descripciontxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        descripciontxt.setForeground(new java.awt.Color(0, 0, 0));
        descripciontxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descripciontxt.setText("Descripcion");
        getContentPane().add(descripciontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 210, 21));

        descripcionTF.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        descripcionTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descripcionTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionTFKeyTyped(evt);
            }
        });
        getContentPane().add(descripcionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 209, 52));

        cantidadJs.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        cantidadJs.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(cantidadJs, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 120, 60));

        precioJs.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        precioJs.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 2.5d));
        getContentPane().add(precioJs, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 120, 60));

        garantiaJs.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        garantiaJs.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(garantiaJs, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 120, 60));

        fondoTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondoTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Producto.jpg"))); // NOI18N
        getContentPane().add(fondoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (infoObligatoria()) {
            JOptionPane.showMessageDialog(this,"No se han llenado los camplos obligatorio","ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else{
            String nombreP = nombreTextF.getText().trim();
            String fabricante = fabricanteTF.getText().trim();
            String codigo = codigoTF.getText().trim();
            int cantidad = (Integer)cantidadJs.getValue();
            double precio = (Double)precioJs.getValue();
            String descripcion = descripcionTF.getText().trim();
            String garantia = garantiaJs.getValue().toString();
            
            Producto producto = new Producto(nombreP, fabricante, descripcion, codigo, precio, garantia);
            Bodega bodega = new Bodega(inicioE.getTxtNombreTienda(), codigo, cantidad);         
            
            try {
                insertarD.crearProducto(conexion, producto);
                insertarD.crearBodega(conexion, bodega);
                JOptionPane.showMessageDialog(this,"Se ha creado el producto","Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se ha podido crear el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void codigoTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTFKeyTyped
        
        if (codigoTF.getText().length()== constantes.LIMITE_CODIGO) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se pueden ingresar mas de 10 digitos","Error", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_codigoTFKeyTyped

    private void codigoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTFActionPerformed
        
        
    }//GEN-LAST:event_codigoTFActionPerformed

    private void nombreTextFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextFKeyTyped
        if (nombreTextF.getText().length()== constantes.LIMITE_NOMBRE) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se pueden ingresar mas de 35 letras","Error", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_nombreTextFKeyTyped

    private void fabricanteTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fabricanteTFKeyTyped
        if (fabricanteTF.getText().length()== constantes.LIMITE_DIRECCION) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se pueden ingresar mas de 45 letras","Error", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_fabricanteTFKeyTyped

    private void descripcionTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionTFKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)
                && !(evt.getKeyChar()==' ')) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se puede ingresar texto", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_descripcionTFKeyTyped

    private boolean infoObligatoria(){
        return (nombreTextF.getText().trim().isEmpty()||fabricanteTF.getText().trim().isEmpty()
                ||codigoTF.getText().trim().isEmpty());       
    }
    
    
    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner cantidadJs;
    private javax.swing.JLabel cantidadtxt;
    private javax.swing.JTextField codigoTF;
    private javax.swing.JLabel codigotxt;
    private javax.swing.JTextField descripcionTF;
    private javax.swing.JLabel descripciontxt;
    private javax.swing.JTextField fabricanteTF;
    private javax.swing.JLabel fabricantetxt;
    private javax.swing.JLabel fondoTienda;
    private javax.swing.JSpinner garantiaJs;
    private javax.swing.JLabel garantiatxt;
    private javax.swing.JTextField nombreTextF;
    private javax.swing.JLabel nombretxt;
    private javax.swing.JButton okButton;
    private javax.swing.JSpinner precioJs;
    private javax.swing.JLabel preciotxt;
    // End of variables declaration//GEN-END:variables
}
