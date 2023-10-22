/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Pestañas.FrameInicio;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author yanar
 */
public class CLogin {
    
    public void validarUsuario(JTextField usuario, JPasswordField contrasena){
        
        try {
            ResultSet rs=null;
            PreparedStatement ps=null;
            
            Conexion.CConexion objetoConexion = new Conexion.CConexion();
            
            String consulta="select * from Usuario where Usuario.usuario =(?) and Usuario.contrasena =(?);";
            ps=objetoConexion.estableceConexion().prepareCall(consulta);
            
            String contra = String.valueOf(contrasena.getPassword());
            
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El Usuario es Correcto.");
                FrameInicio objetoInicio = new FrameInicio();
                objetoInicio.setVisible(true);
                
            }
            else{
               JOptionPane.showMessageDialog(null, "El Usuario es Incorrecto, Vuelva a intentar."); 
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
}
