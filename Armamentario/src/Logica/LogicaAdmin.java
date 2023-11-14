/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conexion.CConexion;
import java.sql.CallableStatement;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author yanar
 */
public class LogicaAdmin {
    
    public DefaultTableModel mostrarUsuario() {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"Usuario", "Contraseña"};
            modelo = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarUsuario()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("usuario"),
                    rs.getString("contrasena")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }   
     
     public boolean registrarUsuario(String usuario, String contrasena) {
        try {
            
            if (existeUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado.", "Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call RegistrarUsuario(?, ?)}");
            cst.setString(1, usuario);
            cst.setString(2, contrasena);

            int filasAfectadas = cst.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
     private boolean existeUsuario(String usuario) {
    try {
        Connection cn = CConexion.getConnection();
        PreparedStatement pst = cn.prepareStatement("SELECT COUNT(*) FROM usuario WHERE usuario = ?");
        pst.setString(1, usuario);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
     
     public boolean editarUsuario(String usuario, String nuevaContrasena) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call EditarUsuario(?, ?)}");
        cst.setString(1, usuario);
        cst.setString(2, nuevaContrasena);

        int filasAfectadas = cst.executeUpdate();

        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean eliminarUsuario(String usuario) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call EliminarUsuario(?)}");
        cst.setString(1, usuario);

        int filasAfectadas = cst.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
