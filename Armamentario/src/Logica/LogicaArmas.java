/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conexion.CConexion;
import java.sql.CallableStatement;
import com.mysql.jdbc.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;





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
}
