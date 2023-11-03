/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author basty
 */
public class LogicaArmas {
    
    public DefaultTableModel mostrarArmas() {
        
        String [] nombresColumnas = {"N° Serie","Categoria","Detalles"};
        String [] armas = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        
        String sql = "SELECT * FROM armamento";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try {
            
            Conexion.CConexion objetoConexion = new Conexion.CConexion();
            
            pst = objetoConexion.estableceConexion().prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                armas[0] = rs.getString("numeroSerie");
                
                armas[1] = rs.getString("categoria");
                
                armas[2] = rs.getString("detalle");
                
                modelo.addRow(armas);
                
            }
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        return modelo;
        
    }
        
            
}
