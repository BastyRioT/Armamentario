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
 * @author basty
 */
public class LogicaArmas {
    
    public DefaultTableModel mostrarArmas() {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles"};
            modelo = new DefaultTableModel(null, titulos);
            
            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call MostrarArmas()}");
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
     public DefaultTableModel buscarArma(String terminoBusqueda) {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"N° Serie", "Categoria", "Detalles"};
            modelo = new DefaultTableModel(null, titulos);

            Connection cn = CConexion.getConnection();
            CallableStatement cst = cn.prepareCall("{call BuscarArma(?)}");
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

        return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean darDeBajaArma(String numeroSerie) {
    try {
        Connection cn = CConexion.getConnection();
        CallableStatement cst = cn.prepareCall("{call DarDeBajaArma(?)}");
        cst.setString(1, numeroSerie);

        int filasAfectadas = cst.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
