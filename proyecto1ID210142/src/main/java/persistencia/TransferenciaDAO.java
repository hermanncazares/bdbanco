
package persistencia;

import clases.Cliente;
import clases.Cuenta;
import clases.Transferencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransferenciaDAO {

    private ConexionBD conexion;

    public TransferenciaDAO() {
        this.conexion = new ConexionBD();
    }

    public Transferencia guardar(Transferencia transferencia) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("INSERT INTO tbtransferencia (idcuenta, destinatario, numCuentaDestinatario, monto)"
                    + "VALUES ('%s', '%s', '%s', '%s')",
                    transferencia.getIdcuenta(),
                    transferencia.getDestinatario(),
                    transferencia.getNumCuentaDestinatario(),
                    transferencia.getMonto());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return transferencia;
    }

    public int selectIdCuenta(String numCuenta) {
        int idcuenta;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select idcuenta from tbcuenta WHERE numeroCuenta"
                    + "='%s'",
                    numCuenta);
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            idcuenta = result.getInt(1);
            conex.close();
        } catch (SQLException ex) {
            return 0;
        }
        return idcuenta;
    }
}
