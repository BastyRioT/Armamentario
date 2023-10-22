/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yanar
 */
public class CConexion {
    Connection conectar;
    
    String usuario="root";
    String contraseña="armamentario1515";
    String bd="bdArmamentario";
    String ip="localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection(cadena,usuario,contraseña);
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente a la base de datos");
            
        }  catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema en la conexion"+ e.toString());
        }
        return conectar;
    }
}
