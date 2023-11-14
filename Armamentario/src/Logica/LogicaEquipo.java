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

/**
 *
 * @author basty
 */
public class LogicaEquipo {
    
    public DefaultTableModel mostrarEquipo() {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles"};
            modelo = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarEquipo()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("numeroSerie"),
                    rs.getString("categoria"),
                    rs.getString("detalle")
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
            String[] titulos = {"N° Serie", "Categoria", "Detalles"};
            modelo = new DefaultTableModel(null, titulos);

            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call BuscarEquipamiento(?)}");
            cst.setString(1, terminoBusqueda);
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("numeroSerie"),
                    rs.getString("categoria"),
                    rs.getString("detalle")
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
            
            // Si se afectó al menos una fila, se considera exitoso
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error, retornamos false
        }
    }
    
    private boolean existeNumeroSerie(String numeroSerie) {
    try {
        Connection cn = CConexion.getConnection();
        PreparedStatement pst = cn.prepareStatement("SELECT COUNT(*) FROM equipamiento WHERE numeroSerie = ?");
        pst.setString(1, numeroSerie);

        ResultSet rs = pst.executeQuery();
        rs.next();

        // Si el resultado es mayor a cero, el número de serie ya existe
        return rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar el número de serie.", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // En caso de error, retornamos false
        }
    }
    public boolean darDeBajaEquipamiento(String numeroSerie) {
    try {
        // Lógica para dar de baja en la base de datos (puedes utilizar un procedimiento almacenado o una consulta SQL DELETE)
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call DarDeBajaEquipamiento(?)}");
        cst.setString(1, numeroSerie);

        int filasAfectadas = cst.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false; // En caso de error, retornamos false
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

        // Si se afectó al menos una fila, se considera exitoso
        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error, retornamos false
        }
    }
}
