package persistencia;

import clases.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacionesDAO {

    private ConexionBD conexion;

    public OperacionesDAO() {
        this.conexion = new ConexionBD();
    }

    public void llenarTabla(JTable tabla, int id,String tipo) {
       if(tipo.equals("Transferencia")){
           try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("SELECT * FROM tbtransferencia WHERE idcuenta=%s", id);
            ResultSet rs = comando.executeQuery(codigo);
            while (rs.next()) {
                String idtransferencia = rs.getString("idtransferencia");
                String idcuenta = rs.getString("idcuenta");
                String destinatario = rs.getString("destinatario");
                String numCuentaDestinatario = rs.getString("numCuentaDestinatario");
                String monto = rs.getString("monto");

                String tbdatos[] = {idtransferencia, idcuenta, destinatario, numCuentaDestinatario, monto};
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.addRow(tbdatos);
            }
            conex.close();
        } catch (SQLException ex) {
        }
       }
        if (tipo.equals("Retiro")) {
            try {
                Connection conex = this.conexion.crearConexion();
                Statement comando = conex.createStatement();
                String codigo2 = String.format("SELECT * FROM tbretirosincuenta WHERE idcuenta=%s",id);
                ResultSet rs = comando.executeQuery(codigo2);
                while (rs.next()) {
                    String idretirosincuenta = rs.getString("idretirosincuenta");
                    String idcuenta = rs.getString("idcuenta");
                    String folioOperacion = rs.getString("folioOperacion");
                    String contraseña = rs.getString("contraseña");
                    String estado = rs.getString("estado");
                    String monto = rs.getString("monto");
                    String nombre = rs.getString("nombre");

                    String tbdatos[] = {idretirosincuenta, idcuenta, folioOperacion, contraseña, estado, monto, nombre};
                    DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                    tb.addRow(tbdatos);
                }
                conex.close();
            } catch (SQLException ex) {
            }
        }
    }
}
