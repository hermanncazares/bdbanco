package persistencia;

import clases.RetiroSinCuenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetiroSinCuentaDAO {

    private ConexionBD conexion;

    public RetiroSinCuentaDAO() {
        this.conexion = new ConexionBD();
    }

    public RetiroSinCuenta guardar(RetiroSinCuenta retiroSinCuenta) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("INSERT INTO tbretirosincuenta (idcuenta, folioOperacion, contraseña, estado, monto, nombre)"
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                    retiroSinCuenta.getIdcuenta(),
                    retiroSinCuenta.getFolioOperacion(),
                    retiroSinCuenta.getContraseña(),
                    retiroSinCuenta.getEstado(),
                    retiroSinCuenta.getMonto(),
                    retiroSinCuenta.getNombre());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return retiroSinCuenta;
    }
}
