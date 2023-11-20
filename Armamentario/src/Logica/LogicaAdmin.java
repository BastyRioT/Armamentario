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
    
    public DefaultTableModel mostrarArmas() {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles", "Retirado Por"};
            modelo = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarArmas()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("numeroSerie"),
                    rs.getString("categoria"),
                    rs.getString("detalle"),
                    rs.getString("retirado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }
    
    public DefaultTableModel mostrarArmasR() {
        DefaultTableModel modeloR = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles", "Retirado Por"};
            modeloR = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarArmasR()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("numeroSerie"),
                    rs.getString("categoria"),
                    rs.getString("detalle"),
                    rs.getString("retirado")
                };
                modeloR.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modeloR;
    }
    
        public boolean EliminarArmaR(String numeroSerie) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call EliminarArmaR(?)}");
        cst.setString(1, numeroSerie);

        int filasAfectadas = cst.executeUpdate();
        if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaArmas logicaArmas = new LogicaArmas();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaArmas.registrarCambio("Eliminar", "Se elimino el arma.", usuarioActual, numeroSerie);
        }
        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
        
    public boolean verificarExistenciaArma(String numeroSerie) {
        try {
            Connection cn = CConexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT COUNT(*) FROM armamento WHERE numeroSerie = ?");
            pst.setString(1, numeroSerie);

            ResultSet rs = pst.executeQuery();
            rs.next();

            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar el arma en la tabla original.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean respaldarArma(String numeroSerie, String categoria, String detalle, String retirado) {
        try {
                if (verificarExistenciaArma(numeroSerie)) {
                    JOptionPane.showMessageDialog(null, "Este arma ya existe en la tabla original.", "Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                Connection cn = CConexion.getConnection();
                CallableStatement cst = cn.prepareCall("{call RespaldarArma(?, ?, ?, ?)}");
                cst.setString(1, numeroSerie);
                cst.setString(2, categoria);
                cst.setString(3, detalle);
                cst.setString(4, retirado);

                int filasAfectadas = cst.executeUpdate();
                return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public DefaultTableModel mostrarEquipo() {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles", "Retirado Por"};
            modelo = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarEquipo()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("numeroSerie"),
                    rs.getString("categoria"),
                    rs.getString("detalle"),
                    rs.getString("retirado")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }
        
    public DefaultTableModel mostrarEquipoR() {
        DefaultTableModel modeloR = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles", "Retirado Por"};
            modeloR = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarEquipoR()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("numeroSerie"),
                    rs.getString("categoria"),
                    rs.getString("detalle"),
                    rs.getString("retirado")
                };
                modeloR.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modeloR;
    }
    
        public boolean EliminarEquipoR(String numeroSerie) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call EliminarEquipoR(?)}");
        cst.setString(1, numeroSerie);

        int filasAfectadas = cst.executeUpdate();
        if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaEquipo logicaEquipo = new LogicaEquipo();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaEquipo.registrarCambio("Dar de Baja", "Se elimino un equipamiento.", usuarioActual, numeroSerie);
        }
        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
        
    public boolean verificarExistenciaEquipo(String numeroSerie) {
        try {
            Connection cn = CConexion.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT COUNT(*) FROM equipamiento WHERE numeroSerie = ?");
            pst.setString(1, numeroSerie);

            ResultSet rs = pst.executeQuery();
            rs.next();

            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar el equipo en la tabla original.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean respaldarEquipo(String numeroSerie, String categoria, String detalle, String retirado) {
        try {
                if (verificarExistenciaEquipo(numeroSerie)) {
                    JOptionPane.showMessageDialog(null, "Este equipamiento ya existe en la tabla original.", "Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                Connection cn = CConexion.getConnection();
                CallableStatement cst = cn.prepareCall("{call RespaldarEquipo(?, ?, ?, ?)}");
                cst.setString(1, numeroSerie);
                cst.setString(2, categoria);
                cst.setString(3, detalle);
                cst.setString(4, retirado);

                int filasAfectadas = cst.executeUpdate();
                return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
