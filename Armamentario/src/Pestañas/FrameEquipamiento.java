/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pestañas;

import Equipamiento.EditarE;
import Equipamiento.RegistroE;
import Logica.LogicaEquipo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author basty
 */
public class FrameEquipamiento extends javax.swing.JFrame {

    /**
     * Creates new form FrameArmas
     */
    public FrameEquipamiento() {
        initComponents();
        mostrarEquipamiento();
    }
    private boolean darDeBajaEquipamiento(String numeroSerie) {
    // Llamar a tu lógica para dar de baja en la base de datos
         LogicaEquipo logica = new LogicaEquipo();
    // Retorna true si la operación fue exitosa, false si hubo un error
        return logica.darDeBajaEquipamiento(numeroSerie);
}
    public void cerrarSesion() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada.");
        this.dispose();
        Login objetoLogin = new Login();
        objetoLogin.setLocationRelativeTo(null);
        objetoLogin.setVisible(true);
    }
    
    public void mostrarEquipamiento() {
        LogicaEquipo logica = new LogicaEquipo();
        DefaultTableModel modelo = logica.mostrarEquipo();
        tblEquipo.setModel(modelo);
    }
    private void realizarBusqueda() {
        LogicaEquipo logica = new LogicaEquipo();
        String terminoBusqueda = txtBuscar.getText();
        DefaultTableModel modelo = logica.buscarEquipamiento(terminoBusqueda);
        tblEquipo.setModel(modelo);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlFondo = new javax.swing.JPanel();
        pnlsTabla = new javax.swing.JScrollPane();
        tblEquipo = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mnbMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemLogout = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Armamento");
        setResizable(false);

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° Serie", "Categoria", "Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlsTabla.setViewportView(tblEquipo);
        if (tblEquipo.getColumnModel().getColumnCount() > 0) {
            tblEquipo.getColumnModel().getColumn(0).setResizable(false);
            tblEquipo.getColumnModel().getColumn(1).setResizable(false);
            tblEquipo.getColumnModel().getColumn(2).setResizable(false);
        }

        pnlFondo.add(pnlsTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 90, 600, 370));

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
        btnRegistrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar Equipo");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 170, 60));

        btnEditar.setBackground(new java.awt.Color(40, 114, 51));
        btnEditar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar Equipo");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 170, 60));

        btnEliminar.setBackground(new java.awt.Color(40, 114, 51));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Dar de Baja");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 170, 60));

        btnVolver.setBackground(new java.awt.Color(40, 114, 51));
        btnVolver.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlFondo.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.png"))); // NOI18N
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuOpciones.setText("Opciones");

        itemLogout.setText("Cerrar Sesión");
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

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_itemLogoutActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrameInicio objetoInicio = new FrameInicio();
        objetoInicio.setLocationRelativeTo(null);
        objetoInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistroE objetoRegistro = new RegistroE(this);
        objetoRegistro.setLocationRelativeTo(null);
        objetoRegistro.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Obtener la fila seleccionada
        int filaSeleccionada = tblEquipo.getSelectedRow();

        // Verificar si se seleccionó alguna fila
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada
            String numeroSerie = tblEquipo.getValueAt(filaSeleccionada, 0).toString();
            String categoria = tblEquipo.getValueAt(filaSeleccionada, 1).toString();
            String detalle = tblEquipo.getValueAt(filaSeleccionada, 2).toString();

            // Crear una instancia de EditarA y pasar los datos
            EditarE ventanaEditar = new EditarE(this, numeroSerie, categoria, detalle);

            ventanaEditar.setLocationRelativeTo(null);
            ventanaEditar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un equipamiento para editar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        realizarBusqueda();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        realizarBusqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    // TODO add your handling code here:
        int filaSeleccionada = tblEquipo.getSelectedRow();
        // Verificar si se seleccionó alguna fila
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada
            String numeroSerie = tblEquipo.getValueAt(filaSeleccionada, 0).toString();
            String categoria = tblEquipo.getValueAt(filaSeleccionada, 1).toString();
            String detalle = tblEquipo.getValueAt(filaSeleccionada, 2).toString();
            // Llamar al método en la lógica para dar de baja
            if (darDeBajaEquipamiento(numeroSerie)) {
                // Eliminar la fila del modelo de la tabla
                DefaultTableModel modelo = (DefaultTableModel) tblEquipo.getModel();
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Equipo dado de baja exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un equipamiento para dar de baja.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameEquipamiento objetoArmas = new FrameEquipamiento();
                objetoArmas.setLocationRelativeTo(null);
                objetoArmas.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JScrollPane pnlsTabla;
    private javax.swing.JTable tblEquipo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
