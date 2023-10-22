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
import javax.swing.Timer;

/**
 *
 * @author basty
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
    
    ImageIcon icAdmin = new ImageIcon(getClass().getResource("/Imagenes/admin.png"));
    Icon iconoAdm = new ImageIcon(icAdmin.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
    itemAdmin.setIcon(iconoAdm);
    
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
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        imgCab = new javax.swing.JLabel();
        pnlInicio = new javax.swing.JPanel();
        btnArmas = new javax.swing.JButton();
        btnEquipamiento = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        lblU = new javax.swing.JLabel();
        lblH = new javax.swing.JLabel();
        lblF = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        mnbMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemLogout = new javax.swing.JMenuItem();
        menuAdmin = new javax.swing.JMenu();
        itemAdmin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Armamentario");
        setBackground(new java.awt.Color(255, 0, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        imgCab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgCab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgInicio.png"))); // NOI18N
        imgCab.setIconTextGap(0);

        pnlInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Bienvenido"));

        btnArmas.setBackground(new java.awt.Color(40, 114, 51));
        btnArmas.setText("Armas");
        btnArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmasActionPerformed(evt);
            }
        });

        btnEquipamiento.setBackground(new java.awt.Color(40, 114, 51));
        btnEquipamiento.setText("Equipamiento");

        btnHistorial.setBackground(new java.awt.Color(40, 114, 51));
        btnHistorial.setText("Historial de Cambios");

        lblU.setText("Usuario:");

        lblH.setText("Hora:");

        lblF.setText("Fecha:");

        lblUsuario.setText("jLabel4");

        lblHora.setText("jLabel4");

        lblFecha.setText("jLabel4");

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlInicioLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblU)
                                .addComponent(lblF)
                                .addComponent(lblH))
                            .addGap(18, 18, 18)
                            .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(lblUsuario)
                                .addComponent(lblHora)
                                .addComponent(lblFecha)))
                        .addGroup(pnlInicioLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(btnArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEquipamiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblU)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblH)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblF)
                    .addComponent(lblFecha))
                .addContainerGap())
        );

        menuOpciones.setText("Opciones");

        itemLogout.setText("Cerrar Sesión");
        menuOpciones.add(itemLogout);

        mnbMenu.add(menuOpciones);

        menuAdmin.setText("Administracion");

        itemAdmin.setText("Ingresar");
        menuAdmin.add(itemAdmin);

        mnbMenu.add(menuAdmin);

        setJMenuBar(mnbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(imgCab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgCab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnArmasActionPerformed

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
                new FrameInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArmas;
    private javax.swing.JButton btnEquipamiento;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JLabel imgCab;
    private javax.swing.JMenuItem itemAdmin;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblH;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblU;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuAdmin;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JPanel pnlInicio;
    // End of variables declaration//GEN-END:variables
}
