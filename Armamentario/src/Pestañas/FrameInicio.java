/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pestañas;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author yanar
 */
public class FrameInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrameInicio
     */
    public FrameInicio() {
        initComponents();
    
    ImageIcon icLogout = new ImageIcon(getClass().getResource("/Imagenes/logout.png"));
    Icon iconoLog = new ImageIcon(icLogout.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
    itemLogout.setIcon(iconoLog);
    
     timer.start();
     
    
    }

    Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Calendar cal = new GregorianCalendar();
                int hh, mm, ss, dia, mes, aa;
                hh = cal.get(Calendar.HOUR_OF_DAY);
                mm = cal.get(Calendar.MINUTE);
                ss = cal.get(Calendar.SECOND);
                
                dia = cal.get(Calendar.DAY_OF_MONTH);
                mes = cal.get(Calendar.MONTH);
                aa = cal.get(Calendar.YEAR);
                
                lblHora.setText(hh+":"+mm+":"+ss);
                lblFecha.setText(dia+"/"+(mes+1)+"/"+aa);
                
            }
    });
    
    public void cerrarSesion() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada.");
        this.dispose();
        Login objetoLogin = new Login();
        objetoLogin.setLocationRelativeTo(null);
        objetoLogin.setVisible(true);
    }

    public void usuarioSesion() {
        //Aquí colocar codigo para que salga el nombre del usuario en el inicio
        
        //lblUsuario.setText();
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
        btnArmas = new javax.swing.JButton();
        btnEquipamiento = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        lbIH = new javax.swing.JLabel();
        lbIF = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        mnbMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 500));
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnArmas.setBackground(new java.awt.Color(40, 114, 51));
        btnArmas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnArmas.setForeground(new java.awt.Color(255, 255, 255));
        btnArmas.setText("Armas");
        btnArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmasActionPerformed(evt);
            }
        });
        pnlFondo.add(btnArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 50));

        btnEquipamiento.setBackground(new java.awt.Color(40, 114, 51));
        btnEquipamiento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        btnEquipamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnEquipamiento.setText("Equipamiento");
        btnEquipamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipamientoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEquipamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 50));

        btnHistorial.setBackground(new java.awt.Color(40, 114, 51));
        btnHistorial.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 13)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Historial de Cambios");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        pnlFondo.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 50));

        lbIH.setText("Hora:");
        pnlFondo.add(lbIH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        lbIF.setText("Fecha:");
        pnlFondo.add(lbIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));
        pnlFondo.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));
        pnlFondo.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        lbInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio2.png"))); // NOI18N
        pnlFondo.add(lbInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmasActionPerformed
        FrameArmas objetoArmas = new FrameArmas();
        objetoArmas.setLocationRelativeTo(null);
        objetoArmas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnArmasActionPerformed

    private void btnEquipamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipamientoActionPerformed
        FrameEquipamiento objetoEquipo = new FrameEquipamiento();
        objetoEquipo.setLocationRelativeTo(null);
        objetoEquipo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEquipamientoActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        FrameCambios objetoCambios = new FrameCambios();
        objetoCambios.setLocationRelativeTo(null);
        objetoCambios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed

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
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameInicio objetoInicio = new FrameInicio();
                objetoInicio.setLocationRelativeTo(null);
                objetoInicio.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArmas;
    private javax.swing.JButton btnEquipamiento;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JLabel lbIF;
    private javax.swing.JLabel lbIH;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
