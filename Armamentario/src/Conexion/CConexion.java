/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
/**
 *
 * @author yanar
 */
public class CConexion {

    static Connection con =null;

    public static Connection getConnection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdarmamentario","root","");

            //JOptionPane.showMessageDialog(null, "Se conecto correctamente a la base de datos");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
