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
import javax.swing.UIManager;
/**
 *
 * @author basty
 */
public class LogicaArmas {
    
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
     public DefaultTableModel buscarArma(String terminoBusqueda) {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles", "Retirado Por"};
            modelo = new DefaultTableModel(null, titulos);

            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call BuscarArma(?)}");
            cst.setString(1, terminoBusqueda);
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
     
     public boolean registrarArma(String numeroSerie, String categoria, String detalles) {
        try {
            
            if (existeNumeroSerie(numeroSerie)) {
                JOptionPane.showMessageDialog(null, "Esta arma ya esta registrada.", "Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call RegistrarArma(?, ?, ?)}");
            cst.setString(1, numeroSerie);
            cst.setString(2, categoria);
            cst.setString(3, detalles);
            

            int filasAfectadas = cst.executeUpdate();
             if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaArmas logicaArmas = new LogicaArmas();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaArmas.registrarCambio("Registro", "Se registró un nuevo arma.", usuarioActual, numeroSerie);
            }   
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
     private boolean existeNumeroSerie(String numeroSerie) {
    try {
        Connection cn = CConexion.getConnection();
        PreparedStatement pst = cn.prepareStatement("SELECT COUNT(*) FROM armamento WHERE numeroSerie = ?");
        pst.setString(1, numeroSerie);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar el número de serie.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
     
     public boolean editarArma(String numeroSerie, String nuevaCategoria, String nuevosDetalles) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call EditarArma(?, ?, ?)}");
        cst.setString(1, numeroSerie);
        cst.setString(2, nuevaCategoria);
        cst.setString(3, nuevosDetalles);

        int filasAfectadas = cst.executeUpdate();
        if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaArmas logicaArmas = new LogicaArmas();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaArmas.registrarCambio("Edición", "Se editó un arma.", usuarioActual, numeroSerie);
        }
        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
    public boolean darDeBajaArma(String numeroSerie) {
    try {
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres dar de baja el arma?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call DarDeBajaArma(?)}");
            cst.setString(1, numeroSerie);

            int filasAfectadas = cst.executeUpdate();
            if (filasAfectadas > 0) {
                LogicaEquipo logicaEquipo = new LogicaEquipo();
                String usuarioActual = SesionUsuario.getUsuarioActual();
                logicaEquipo.registrarCambio("Dar de Baja", "Se dio de baja un arma.", usuarioActual, numeroSerie);
            }
            return filasAfectadas > 0;
        } else {
            return false;
        }

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public boolean retirarArma(String numeroSerie, String retiradoPor) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call RetirarArma(?, ?)}");
        cst.setString(1, numeroSerie);
        cst.setString(2, retiradoPor);

        int filasAfectadas = cst.executeUpdate();
        if (filasAfectadas > 0) {
            LogicaArmas logicaArmas = new LogicaArmas();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaArmas.registrarCambio("Retiro", "Se retiró un arma.", usuarioActual, numeroSerie);
        }
        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registrarCambio(String tipoCambio, String detalles, String usuario, String numeroSerie) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call RegistrarCambio(?, ?, ?, ?)}");
        cst.setString(1, tipoCambio);
        cst.setString(2, detalles);
        cst.setString(3, usuario);
        cst.setString(4, numeroSerie);

        int filasAfectadas = cst.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public boolean reingresarArma(String numeroSerie) {
        try {
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call ReingresarArma(?)}");
            cst.setString(1, numeroSerie);

            int filasAfectadas = cst.executeUpdate();
            if (filasAfectadas > 0) {
                LogicaArmas logicaArmas = new LogicaArmas();
                String usuarioActual = SesionUsuario.getUsuarioActual();
                logicaArmas.registrarCambio("Reingreso", "Se reingresó un arma.", usuarioActual, numeroSerie);
            }
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
