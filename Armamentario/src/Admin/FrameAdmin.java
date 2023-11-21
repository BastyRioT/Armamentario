/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Logica.LogicaAdmin;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author yanar
 */
public class FrameAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FrameAdmin
     */
    public FrameAdmin() {
        initComponents();
        mostrarUsuarios();
    }

    public void mostrarUsuarios() {
        LogicaAdmin logica = new LogicaAdmin();
        DefaultTableModel modelo = logica.mostrarUsuario();
        tblUsuarios.setModel(modelo);
    }
    
    private boolean eliminarUsuario(String usuario) {
    // Llamar a tu lógica para dar de baja en la base de datos
        LogicaAdmin logica = new LogicaAdmin();
    // Retorna true si la operación fue exitosa, false si hubo un error
        return logica.eliminarUsuario(usuario);
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
        pnlCredenciales = new javax.swing.JPanel();
        btnRegistroUs = new javax.swing.JButton();
        btnEditarUs = new javax.swing.JButton();
        btnEliminarUs = new javax.swing.JButton();
        pnlsTabla = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        pnlRespaldo = new javax.swing.JPanel();
        btnRespaldoE = new javax.swing.JButton();
        btnRespaldoA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administración");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/sombrerito.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        setResizable(false);

        pnlCredenciales.setBorder(javax.swing.BorderFactory.createTitledBorder("Credenciales Usuarios"));

        btnRegistroUs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistroUs.setText("Registrar Usuario");
        btnRegistroUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroUsActionPerformed(evt);
            }
        });

        btnEditarUs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEditarUs.setText("Editar Contraseña");
        btnEditarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsActionPerformed(evt);
            }
        });

        btnEliminarUs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminarUs.setText("Eliminar Usuario");
        btnEliminarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCredencialesLayout = new javax.swing.GroupLayout(pnlCredenciales);
        pnlCredenciales.setLayout(pnlCredencialesLayout);
        pnlCredencialesLayout.setHorizontalGroup(
            pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredencialesLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarUs, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarUs, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroUs, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCredencialesLayout.setVerticalGroup(
            pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredencialesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnRegistroUs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnEditarUs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnEliminarUs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Contraseña"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlsTabla.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        pnlRespaldo.setBorder(javax.swing.BorderFactory.createTitledBorder("Respaldo"));

        btnRespaldoE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRespaldoE.setText("Respaldo Equipamiento");
        btnRespaldoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespaldoEActionPerformed(evt);
            }
        });

        btnRespaldoA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRespaldoA.setText("Respaldo Armamento");
        btnRespaldoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespaldoAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRespaldoLayout = new javax.swing.GroupLayout(pnlRespaldo);
        pnlRespaldo.setLayout(pnlRespaldoLayout);
        pnlRespaldoLayout.setHorizontalGroup(
            pnlRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRespaldoLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnlRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRespaldoE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRespaldoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        pnlRespaldoLayout.setVerticalGroup(
            pnlRespaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRespaldoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(btnRespaldoA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRespaldoE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlCredenciales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlRespaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlsTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(pnlsTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(18, 18, 18))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

    private void btnRegistroUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroUsActionPerformed
        RegistrarU objetoRegistro = new RegistrarU(this);
        objetoRegistro.setLocationRelativeTo(null);
        objetoRegistro.setVisible(true);
    }//GEN-LAST:event_btnRegistroUsActionPerformed

    private void btnEditarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsActionPerformed
        // Obtener la fila seleccionada
        int filaSeleccionada = tblUsuarios.getSelectedRow();

        // Verificar si se seleccionó alguna fila
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada
            String usuario = tblUsuarios.getValueAt(filaSeleccionada, 0).toString();
            String contraseña = tblUsuarios.getValueAt(filaSeleccionada, 1).toString();

            // Crear una instancia de EditarA y pasar los datos
            EditarU ventanaEditar = new EditarU(this, usuario, contraseña);

            ventanaEditar.setLocationRelativeTo(null);
            ventanaEditar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para editar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarUsActionPerformed

    private void btnEliminarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblUsuarios.getSelectedRow();
        // Verificar si se seleccionó alguna fila
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada
            String usuario = tblUsuarios.getValueAt(filaSeleccionada, 0).toString();
            // Llamar al método en la lógica para dar de baja
            if (eliminarUsuario(usuario)) {
                // Eliminar la fila del modelo de la tabla
                DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un usuario para eliminarlo.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarUsActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRespaldoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldoEActionPerformed
        FrameRespaldoE objetoFrame = new FrameRespaldoE();
        objetoFrame.setLocationRelativeTo(null);
        objetoFrame.setVisible(true);
    }//GEN-LAST:event_btnRespaldoEActionPerformed

    private void btnRespaldoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldoAActionPerformed
        FrameRespaldoA objetoFrame = new FrameRespaldoA();
        objetoFrame.setLocationRelativeTo(null);
        objetoFrame.setVisible(true);
    }//GEN-LAST:event_btnRespaldoAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameAdmin objetoInicio = new FrameAdmin();
                objetoInicio.setLocationRelativeTo(null);
                objetoInicio.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarUs;
    private javax.swing.JButton btnEliminarUs;
    private javax.swing.JButton btnRegistroUs;
    private javax.swing.JButton btnRespaldoA;
    private javax.swing.JButton btnRespaldoE;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel pnlCredenciales;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlRespaldo;
    private javax.swing.JScrollPane pnlsTabla;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
