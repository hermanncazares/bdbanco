package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hermann
 */
public class ConexionBD implements IConexionBD {

    private final String Server = "localhost:3306";
    private final String BASE_DATOS = "bdbank";
    private final String CONEXION = "jdbc:mysql://" + Server + "/" + BASE_DATOS;
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "12345";

    @Override

    public Connection crearConexion() throws SQLException {
        Connection conexion;
        conexion = DriverManager.getConnection(CONEXION, USUARIO, CONTRASEÑA);
        return conexion;
    }
}
