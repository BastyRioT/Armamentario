/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conexion.CConexion;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
