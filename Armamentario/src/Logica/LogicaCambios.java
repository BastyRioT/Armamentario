package Logica;

import Conexion.CConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nacho
 */
public class LogicaCambios {
    
    public DefaultTableModel mostrarCambios() {
        DefaultTableModel modelo = null;
        try {
            String[] titulos = {"Fecha de Cambio", "Tipo de Cambio", "Detalles", "Usuario", "N° de Serie"};
            modelo = new DefaultTableModel(null, titulos);

            Connection cn = CConexion.getConnection();
            CallableStatement cst = (CallableStatement) cn.prepareCall("{call MostrarCambios()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Object[] fila = {
                    rs.getTimestamp("fechaCambio"),
                    rs.getString("tipoCambio"),
                    rs.getString("detalles"),
                    rs.getString("usuario"),
                    rs.getString("numeroSerie")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }
}
