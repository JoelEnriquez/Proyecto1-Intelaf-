/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmpleado;

import ConexionSQL.Consultas;
import ConexionSQL.ConsultasProducto;
import ConexionSQL.InsertarData;
import EntidadesCompra.Venta;
import EntidadesPersona.Cliente;
import EntidadesTienda.Bodega;
import EntidadesTienda.PaqueteVenta;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joel
 */
public class RealizarVenta extends javax.swing.JDialog {

    private InsertarData insertarD;
    private Connection conexion;
    private Consultas consul;
    private ConsultasProducto consulPro;
    private DefaultTableModel dtModel;
    private ArrayList<String[]> listaProductosEnTabla;
    private InicioEmpleado inicioE;
    private String linea;
    private double total;
    private ArrayList<String> listaNIT;
    private ArrayList<String> listaCodigoProducto;
    private ArrayList<PaqueteVenta> paquetesVenta;
    private Cliente cliente;
    private Bodega bodega;
    
    public RealizarVenta(java.awt.Frame parent, boolean modal, InsertarData insertarD,
            Connection conexion, Consultas consul, InicioEmpleado inicioE) {
        super(parent, modal);
        initComponents();
        this.insertarD = insertarD;
        this.conexion = conexion;
        this.consul = consul;
        this.inicioE =inicioE;
        dtModel = new DefaultTableModel();
        consulPro = new ConsultasProducto();
        listaProductosEnTabla = new ArrayList<>();
        
        listaNIT = new ArrayList<>();
        listaCodigoProducto = new ArrayList<>();
        
        construirTabla();
        ponerEnTabla();
        desactivarElementos();
        contruirComboNITProductos();
    }
    
    private void desactivarElementos(){
        codigoProductoCombo.setEnabled(false);
        cantidadJS.setEnabled(false);
        agregarAColaButton.setEnabled(false);
        venderAhoraButton.setEnabled(false);
    }

    private  void contruirComboNITProductos(){
        consul.getNIT_Clientes(conexion, listaNIT);
        consul.getCodigoProducto(conexion, listaCodigoProducto);
        
        for (int i = 0; i < listaCodigoProducto.size(); i++) {
            codigoProductoCombo.addItem(listaCodigoProducto.get(i));
        }
        
        for (int i = 0; i < listaNIT.size(); i++) {
            comboNIT.addItem(listaNIT.get(i));
        }
    }
    
    private void mostrarInfoTabla(){
                
        for (int i = 1; i < listaProductosEnTabla.size(); i++) {
                dtModel.addRow(listaProductosEnTabla.get(i));
            }
        tablaProductos.setModel(dtModel);

    }
    
    
    private void ponerEnTabla(){
        consulPro.obtenerTodosLosProductos(conexion, listaProductosEnTabla, inicioE.getTxtNombreTienda());
        mostrarInfoTabla();
    }

    public void construirTabla(){
        dtModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        dtModel.addColumn("Codigo");
        dtModel.addColumn("Nombre");
        dtModel.addColumn("Fabricante");
        dtModel.addColumn("Precio");
        dtModel.addColumn("Descripcion");
        dtModel.addColumn("Garantia");
        dtModel.addColumn("Cantidad");       
        
        tablaProductos.setModel(dtModel);       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        listadoProductostxt = new javax.swing.JLabel();
        NITtxt = new javax.swing.JLabel();
        codigoProductoCombo = new javax.swing.JComboBox<>();
        agregarAColaButton = new javax.swing.JButton();
        cantidadJS = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        ventasEnCola = new javax.swing.JTextArea();
        venderAhoraButton = new javax.swing.JButton();
        totalTF = new javax.swing.JTextField();
        totaltxt = new javax.swing.JLabel();
        cantidadtxt = new javax.swing.JLabel();
        comboNIT = new javax.swing.JComboBox<>();
        codigoProductotxt = new javax.swing.JLabel();
        aceptarButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProductos.setViewportView(tablaProductos);

        listadoProductostxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        listadoProductostxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listadoProductostxt.setText("Listado de Productos");

        NITtxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NITtxt.setText("NIT");

        codigoProductoCombo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        agregarAColaButton.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        agregarAColaButton.setText("Agregar a la cola");
        agregarAColaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAColaButtonActionPerformed(evt);
            }
        });

        cantidadJS.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cantidadJS.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        ventasEnCola.setColumns(20);
        ventasEnCola.setRows(5);
        jScrollPane2.setViewportView(ventasEnCola);

        venderAhoraButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        venderAhoraButton.setText("Vender Ahora");
        venderAhoraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderAhoraButtonActionPerformed(evt);
            }
        });

        totalTF.setEditable(false);
        totalTF.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        totalTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTFActionPerformed(evt);
            }
        });

        totaltxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totaltxt.setText("Total");

        cantidadtxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cantidadtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantidadtxt.setText("Cantidad");

        comboNIT.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        codigoProductotxt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        codigoProductotxt.setText("Codigo Producto");

        aceptarButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar (1).png"))); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listadoProductostxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollProductos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(NITtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadJS, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoProductoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarAColaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoProductotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(venderAhoraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(totaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listadoProductostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codigoProductotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codigoProductoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cantidadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadJS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarAColaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NITtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(venderAhoraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarAColaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAColaButtonActionPerformed
        
        double costoSuma = consul.precioProdcuto(conexion, codigoProductoCombo.getSelectedItem().toString());
        if (cliente.getCredito()+cliente.getEfectivo()<costoSuma) {
            JOptionPane.showMessageDialog(this, "El usuario no tiene sufiente dinero");
        }
        int idPaquete = consul.idPedidoActual(conexion)+1;
        paquetesVenta = new ArrayList<>();
        
        total+=costoSuma;
        
        PaqueteVenta paqueteVenta = new PaqueteVenta(idPaquete, codigoProductoCombo.getSelectedItem().toString(), (Integer)cantidadJS.getValue(), costoSuma);
        
          venderAhoraButton.setEnabled(true);
    }//GEN-LAST:event_agregarAColaButtonActionPerformed

    private void venderAhoraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderAhoraButtonActionPerformed
        String NITCliente = comboNIT.getSelectedItem().toString();
        
        Venta venta = new Venta(Date.valueOf(inicioE.getTxtFechaActual()), NITCliente, total, inicioE.getTxtNombreTienda());
        
    }//GEN-LAST:event_venderAhoraButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        aceptarButton.setEnabled(false);
        comboNIT.setEnabled(false);
        
        codigoProductoCombo.setEnabled(false);
        cantidadJS.setEnabled(false);
        agregarAColaButton.setEnabled(false);
        
        cliente = consul.getCliente(conexion, comboNIT.getSelectedItem().toString());
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void totalTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTFActionPerformed
        if (rootPaneCheckingEnabled) {
            
        }
    }//GEN-LAST:event_totalTFActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NITtxt;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton agregarAColaButton;
    private javax.swing.JSpinner cantidadJS;
    private javax.swing.JLabel cantidadtxt;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> codigoProductoCombo;
    private javax.swing.JLabel codigoProductotxt;
    private javax.swing.JComboBox<String> comboNIT;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel listadoProductostxt;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField totalTF;
    private javax.swing.JLabel totaltxt;
    private javax.swing.JButton venderAhoraButton;
    private javax.swing.JTextArea ventasEnCola;
    // End of variables declaration//GEN-END:variables
}
