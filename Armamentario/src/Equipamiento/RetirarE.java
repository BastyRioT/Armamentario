/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Equipamiento;

import Logica.LogicaEquipo;
import Pestañas.FrameEquipamiento;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

/**
 *
 * @author basty
 */
public class RetirarE extends javax.swing.JFrame {
    
    private FrameEquipamiento frameEquipamiento;
    /**
     * Creates new form RegistroA
     */
    public RetirarE(FrameEquipamiento frameEquipamiento, String numeroSerie, String retirado) {
        initComponents();
        this.frameEquipamiento = frameEquipamiento;
        txtNumero.setText(numeroSerie);
        txtRetirar.setText(retirado);
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(rbSi);
        grupoBotones.add(rbNo);
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
        btnRetirar = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        lbNSerie = new javax.swing.JLabel();
        lbDetalle = new javax.swing.JLabel();
        txtRetirar = new javax.swing.JTextField();
        txtCursos = new javax.swing.JLabel();
        rbSi = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Retirar Equipamiento");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/sombrerito.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        setResizable(false);

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 233, -1, 30));

        txtNumero.setEnabled(false);
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        pnlFondo.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 240, -1));

        lbNSerie.setText("N° De Serie");
        pnlFondo.add(lbNSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        lbDetalle.setText("Nombre de quien retira");
        pnlFondo.add(lbDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        txtRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRetirarActionPerformed(evt);
            }
        });
        pnlFondo.add(txtRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 240, -1));

        txtCursos.setText("¿Tiene el curso correspondiente?");
        pnlFondo.add(txtCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        rbSi.setText("Si");
        pnlFondo.add(rbSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        rbNo.setText("No");
        pnlFondo.add(rbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar.png"))); // NOI18N
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        String numeroSerie = txtNumero.getText();
        String retiradoPor = txtRetirar.getText();
        
        if (retiradoPor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre de la persona que retira.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
        }
        
        if (rbSi.isSelected()) {
            if (retiradoPor.length() > 50) {
                JOptionPane.showMessageDialog(null, "El nombre de quien retira no puede tener más de 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (rbNo.isSelected()) {
            JOptionPane.showMessageDialog(this, "No se puede retirar el equipamiento porque no tiene el curso correspondiente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione si tiene el curso correspondiente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LogicaEquipo logica = new LogicaEquipo();
        boolean exito = logica.retirarEquipo(numeroSerie, retiradoPor);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Se retiro el equipamiento con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            frameEquipamiento.mostrarEquipamiento();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al retirar el eqeuipamiento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void txtRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRetirarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRetirarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbDetalle;
    private javax.swing.JLabel lbNSerie;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbSi;
    private javax.swing.JLabel txtCursos;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRetirar;
    // End of variables declaration//GEN-END:variables
}
