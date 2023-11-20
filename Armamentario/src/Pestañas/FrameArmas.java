/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pestañas;

import Armamento.EditarA;
import Armamento.RegistroA;
import Armamento.RetirarA;
import Logica.LogicaArmas;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author basty
 */
public class FrameArmas extends javax.swing.JFrame {

    /**
     * Creates new form FrameArmas
     */
   public FrameArmas() {
        initComponents();
        mostrarArmamento();
        
        ImageIcon icLogout = new ImageIcon(getClass().getResource("/Imagenes/logout.png"));
        Icon iconoLog = new ImageIcon(icLogout.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        itemLogout.setIcon(iconoLog);
    }
    
    
    public void cerrarSesion() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada.");
        this.dispose();
        Login objetoLogin = new Login();
        objetoLogin.setLocationRelativeTo(null);
        objetoLogin.setVisible(true);
    }
    
    public void mostrarArmamento() {
        LogicaArmas logica = new LogicaArmas();
        DefaultTableModel modelo = logica.mostrarArmas();
        tblArmas.setModel(modelo);
    }
    private boolean darDeBajaArma(String numeroSerie) {
        LogicaArmas logica = new LogicaArmas();
        return logica.darDeBajaArma(numeroSerie);
}
    
    private void realizarBusqueda() {
        LogicaArmas logica = new LogicaArmas();
        String terminoBusqueda = txtBuscar.getText();
        DefaultTableModel modelo = logica.buscarArma(terminoBusqueda);
        tblArmas.setModel(modelo);
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
        pnlsTabla = new javax.swing.JScrollPane();
        tblArmas = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDarDeBaja = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnReingresar = new javax.swing.JButton();
        lbFArmas = new javax.swing.JLabel();
        mnbMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Armamento");
        setResizable(false);

        pnlFondo.setMinimumSize(new java.awt.Dimension(900, 500));
        pnlFondo.setPreferredSize(new java.awt.Dimension(900, 500));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblArmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Serie", "Categoria", "Detalles", "Retirado Por"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlsTabla.setViewportView(tblArmas);
        if (tblArmas.getColumnModel().getColumnCount() > 0) {
            tblArmas.getColumnModel().getColumn(0).setResizable(false);
            tblArmas.getColumnModel().getColumn(1).setResizable(false);
            tblArmas.getColumnModel().getColumn(2).setResizable(false);
            tblArmas.getColumnModel().getColumn(3).setResizable(false);
        }

        pnlFondo.add(pnlsTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 600, 370));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 190, -1));

        btnBuscar.setBackground(new java.awt.Color(40, 114, 51));
        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(40, 114, 51));
        btnRegistrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 170, 60));

        btnEditar.setBackground(new java.awt.Color(40, 114, 51));
        btnEditar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, 60));

        btnDarDeBaja.setBackground(new java.awt.Color(40, 114, 51));
        btnDarDeBaja.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnDarDeBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnDarDeBaja.setText("Dar de Baja");
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });
        pnlFondo.add(btnDarDeBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 170, 60));

        btnVolver.setBackground(new java.awt.Color(40, 114, 51));
        btnVolver.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlFondo.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 170, 40));

        btnRetirar.setBackground(new java.awt.Color(40, 114, 51));
        btnRetirar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnRetirar.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 170, 60));

        btnReingresar.setBackground(new java.awt.Color(40, 114, 51));
        btnReingresar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnReingresar.setForeground(new java.awt.Color(255, 255, 255));
        btnReingresar.setText("Reingresar");
        btnReingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReingresarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnReingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 170, 60));

        lbFArmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.png"))); // NOI18N
        pnlFondo.add(lbFArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuOpciones.setText("Cerrar Sesión");

        itemLogout.setText("Salir");
        itemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLogoutActionPerformed(evt);
            }
        });
        menuOpciones.add(itemLogout);

        mnbMenu.add(menuOpciones);

        setJMenuBar(mnbMenu);

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

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

        realizarBusqueda();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        realizarBusqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrameInicio objetoInicio = new FrameInicio();
        objetoInicio.setLocationRelativeTo(null);
        objetoInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int filaSeleccionada = tblArmas.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            String numeroSerie = tblArmas.getValueAt(filaSeleccionada, 0).toString();
            String categoria = tblArmas.getValueAt(filaSeleccionada, 1).toString();
            String detalle = tblArmas.getValueAt(filaSeleccionada, 2).toString();

            EditarA ventanaEditar = new EditarA(this, numeroSerie, categoria, detalle);

            ventanaEditar.setLocationRelativeTo(null);
            ventanaEditar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un arma para editar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaActionPerformed

        int filaSeleccionada = tblArmas.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            String numeroSerie = tblArmas.getValueAt(filaSeleccionada, 0).toString();
            String categoria = tblArmas.getValueAt(filaSeleccionada, 1).toString();
            String detalle = tblArmas.getValueAt(filaSeleccionada, 2).toString();
            if (darDeBajaArma(numeroSerie)) {
                DefaultTableModel modelo = (DefaultTableModel) tblArmas.getModel();
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Arma dada de baja exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el arma.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un arma para dar de baja.", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDarDeBajaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistroA objetoRegistro = new RegistroA(this);
        objetoRegistro.setLocationRelativeTo(null);
        objetoRegistro.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        int filaSeleccionada = tblArmas.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            String numeroSerie = tblArmas.getValueAt(filaSeleccionada, 0).toString();
            String retirado = tblArmas.getValueAt(filaSeleccionada, 3).toString();

            RetirarA ventanaRetirar = new RetirarA(this, numeroSerie, retirado);

            ventanaRetirar.setLocationRelativeTo(null);
            ventanaRetirar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un arma para retirar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnReingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReingresarActionPerformed
    int filaSeleccionada = tblArmas.getSelectedRow();

    if (filaSeleccionada != -1) {
        String numeroSerie = tblArmas.getValueAt(filaSeleccionada, 0).toString();
        String retirado = tblArmas.getValueAt(filaSeleccionada, 3).toString();

        if (retirado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Esta arma no se puede reingresar porque no ha sido retirada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                LogicaArmas logica = new LogicaArmas();
                if (logica.reingresarArma(numeroSerie)) {
                    JOptionPane.showMessageDialog(this, "Arma reingresada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    mostrarArmamento();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al reingresar el arma.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para reingresar el arma.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnReingresarActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_itemLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(FrameArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameArmas objetoArmas = new FrameArmas();
                objetoArmas.setLocationRelativeTo(null);
                objetoArmas.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReingresar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JLabel lbFArmas;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JScrollPane pnlsTabla;
    private javax.swing.JTable tblArmas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

  
}
