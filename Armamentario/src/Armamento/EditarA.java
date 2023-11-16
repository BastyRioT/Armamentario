/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Armamento;

import Logica.LogicaArmas;
import Pestañas.FrameArmas;
import javax.swing.JOptionPane;

/**
 *
 * @author basty
 */
public class EditarA extends javax.swing.JFrame {
    
    private FrameArmas frameArmas;
    /**
     * Creates new form RegistroA
     */
    public EditarA(FrameArmas frameArmas, String numeroSerie, String categoria, String detalles) {
        initComponents();
        this.frameArmas = frameArmas;
        txtNumero.setText(numeroSerie);
        cmbCategoria.setSelectedItem(categoria);
        txtDetalle.setText(detalles);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        txtDetalle = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        lbNSerie = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbDetalle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Arma");
        setResizable(false);

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 233, -1, 30));

        txtNumero.setEnabled(false);
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        pnlFondo.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 240, -1));
        pnlFondo.add(txtDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 240, 40));

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pistola", "Subfusil", "Escopeta", "Rifle" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        pnlFondo.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 240, -1));

        lbNSerie.setText("N° De Serie");
        pnlFondo.add(lbNSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        lbCategoria.setText("Categoria");
        pnlFondo.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        lbDetalle.setText("Detalles");
        pnlFondo.add(lbDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar.png"))); // NOI18N
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String numeroSerie = txtNumero.getText();
        String nuevaCategoria = cmbCategoria.getSelectedItem().toString();
        String nuevosDetalles = txtDetalle.getText();

        LogicaArmas logica = new LogicaArmas();
        boolean exito = logica.editarArma(numeroSerie, nuevaCategoria, nuevosDetalles);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Edición exitosa.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            frameArmas.mostrarArmamento();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al editar el arma.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbDetalle;
    private javax.swing.JLabel lbNSerie;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
