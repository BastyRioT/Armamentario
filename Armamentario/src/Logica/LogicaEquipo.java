/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conexion.CConexion;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author basty
 */
public class LogicaEquipo {
    
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
    public DefaultTableModel buscarEquipamiento(String terminoBusqueda) {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles", "Retirado Por"};
            modelo = new DefaultTableModel(null, titulos);

            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call BuscarEquipamiento(?)}");
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
    
    public boolean registrarEquipo(String numeroSerie, String categoria, String detalles) {
        try {
            
            if (existeNumeroSerie(numeroSerie)) {
                JOptionPane.showMessageDialog(null, "Este equipo ya esta registrado.", "Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call RegistrarEquipo(?, ?, ?)}");
            cst.setString(1, numeroSerie);
            cst.setString(2, categoria);
            cst.setString(3, detalles);

            int filasAfectadas = cst.executeUpdate();
            if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaEquipo logicaEquipo = new LogicaEquipo();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaEquipo.registrarCambio("Registro", "Se registro un equipamiento.", usuarioActual, numeroSerie);
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
        PreparedStatement pst = cn.prepareStatement("SELECT COUNT(*) FROM equipamiento WHERE numeroSerie = ?");
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
    public boolean darDeBajaEquipamiento(String numeroSerie) {
     try {
         UIManager.put("OptionPane.yesButtonText", "Sí");
         UIManager.put("OptionPane.noButtonText", "No");
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres dar de baja el equipamiento?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call DarDeBajaEquipamiento(?)}");
            cst.setString(1, numeroSerie);

            int filasAfectadas = cst.executeUpdate();
            if (filasAfectadas > 0) {
                LogicaEquipo logicaEquipo = new LogicaEquipo();
                String usuarioActual = SesionUsuario.getUsuarioActual();
                logicaEquipo.registrarCambio("Dar de Baja", "Se dio de baja un equipamiento.", usuarioActual, numeroSerie);
            }
            return filasAfectadas > 0;
        } else {
            // El usuario ha hecho clic en "No" o ha cerrado el cuadro de diálogo
            return false;
        }

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    
    public boolean editarEquipo(String numeroSerie, String nuevaCategoria, String nuevosDetalles) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call EditarEquipo(?, ?, ?)}");
        cst.setString(1, numeroSerie);
        cst.setString(2, nuevaCategoria);
        cst.setString(3, nuevosDetalles);

        int filasAfectadas = cst.executeUpdate();
        if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaEquipo logicaEquipo = new LogicaEquipo();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaEquipo.registrarCambio("Edición", "Se editó un equipamiento.",usuarioActual, numeroSerie);
        }
        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public boolean retirarEquipo(String numeroSerie, String retiradoPor) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call RetirarEquipo(?, ?)}");
        cst.setString(1, numeroSerie);
        cst.setString(2, retiradoPor);

        int filasAfectadas = cst.executeUpdate();
        if (filasAfectadas > 0) {
            // Registrar el cambio en la tabla de cambios
            LogicaEquipo logicaEquipo = new LogicaEquipo();
            String usuarioActual = SesionUsuario.getUsuarioActual();
            logicaEquipo.registrarCambio("Retiro", "Se retiró un equipo.", usuarioActual, numeroSerie);
        }
        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public void registrarCambio(String tipoCambio, String detalles, String usuario, String numeroSerie) {
        try {
            Connection cn = CConexion.getConnection();
            CallableStatement cst = (CallableStatement) cn.prepareCall("{call RegistrarCambio(?, ?, ?, ?)}");

            cst.setString(1, tipoCambio);
            cst.setString(2, detalles);
            cst.setString(3, usuario); // Utiliza el usuario proporcionado en el método
            cst.setString(4, numeroSerie);

            int filasAfectadas = cst.executeUpdate();

            if (filasAfectadas > 0) {
                // Registro exitoso, puedes realizar otras acciones si es necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    public boolean reingresarEquipo(String numeroSerie) {
        try {
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call ReingresarEquipo(?)}");
            cst.setString(1, numeroSerie);

            int filasAfectadas = cst.executeUpdate();
            if (filasAfectadas > 0) {
                LogicaEquipo logicaEquipo= new LogicaEquipo();
                String usuarioActual = SesionUsuario.getUsuarioActual();
                logicaEquipo.registrarCambio("Reingreso", "Se reingresó un equipamiento.", usuarioActual, numeroSerie);
            }
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

