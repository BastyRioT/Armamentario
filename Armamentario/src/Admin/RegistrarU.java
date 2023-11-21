/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Logica.LogicaAdmin;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author yanar
 */
public class RegistrarU extends javax.swing.JFrame {

    private FrameAdmin frameAdmin;
    /**
     * Creates new form RegistrarU
     */
    public RegistrarU(FrameAdmin frameAdmin) {
        initComponents();
        this.frameAdmin = frameAdmin;
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
        lbUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lbContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/sombrerito.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        setResizable(false);

        pnlFondo.setPreferredSize(new java.awt.Dimension(600, 300));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbUsuario.setText("Usuario");
        pnlFondo.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));
        pnlFondo.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 233, -1));

        lbContraseña.setText("Contraseña");
        pnlFondo.add(lbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));
        pnlFondo.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 233, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        
        if (usuario.length() > 50) {
            JOptionPane.showMessageDialog(null, "El usuario no puede tener más de 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (contraseña.length() > 50) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede tener más de 50 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            LogicaAdmin logica = new LogicaAdmin();
            boolean registroExitoso = logica.registrarUsuario(usuario, contraseña);
            if (registroExitoso) {
            JOptionPane.showMessageDialog(this, "Registro exitoso");
            frameAdmin.mostrarUsuarios();
            this.dispose();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
