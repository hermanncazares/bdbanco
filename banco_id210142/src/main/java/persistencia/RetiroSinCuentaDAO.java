package persistencia;

import clases.RetiroSinCuenta;
import java.awt.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetiroSinCuentaDAO {

    private ConexionBD conexion;

    public RetiroSinCuentaDAO() {
        this.conexion = new ConexionBD();
    }

    public void update(String folio) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("UPDATE tbretirosincuenta SET estado='COBRADO'"
                    + "WHERE  folioOperacion= '%s';",
                    folio);
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
        }
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

    public String selectNombre(RetiroSinCuenta retiroSinCuenta) {
        String nombre;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select nombre from tbretirosincuenta WHERE folioOperacion='%s' AND contraseña='%s'", retiroSinCuenta.getFolioOperacion(), retiroSinCuenta.getContraseña());
            comando.executeQuery(codigo);
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            nombre = result.getString(1);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return nombre;
    }

    public int selectSaldo(RetiroSinCuenta retiroSinCuenta) {
        int saldo;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select monto from tbretirosincuenta WHERE folioOperacion='%s' AND contraseña='%s'", retiroSinCuenta.getFolioOperacion(), retiroSinCuenta.getContraseña());
            comando.executeQuery(codigo);
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            saldo = result.getInt(1);
            conex.close();
        } catch (SQLException ex) {
            return 0;
        }
        return saldo;
    }

    
     public String generarFolio() {
        int numero;
        String banco = "1234567890ABCDFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        for (int x = 0; x < 7; x++) {
            numero = (int) (Math.random() * 8 + 1);
            int indiceAleatorio = numero;
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
            numero = 0;
        }
        return cadena;
    }
     
     public String generarContrasena() {
        int numero;
        String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        for (int x = 0; x < 10; x++) {
            numero = (int) (Math.random() * 8 + 1);
            int indiceAleatorio = numero;
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
            numero = 0;
        }
        return cadena;
    }
     
     
}
