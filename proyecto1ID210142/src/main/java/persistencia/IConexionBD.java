package persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hermann
 */
public interface IConexionBD {

    public Connection crearConexion() throws SQLException;
}
