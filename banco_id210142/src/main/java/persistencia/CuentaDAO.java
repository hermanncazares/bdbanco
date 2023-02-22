package persistencia;

import clases.Cuenta;
import java.awt.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class CuentaDAO {

    private ConexionBD conexion;

    public CuentaDAO() {
        this.conexion = new ConexionBD();
    }

    public void updateSaldoTransferencia(int idorigen, int iddestino, int monto, int idcuentatotalorigen, int idcuentatotaldestino) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("UPDATE tbcuenta SET saldo = (saldo + %s) where idcuenta=%s",
                    monto,
                    iddestino);
            comando.executeUpdate(codigo);
            String codigo2 = String.format("UPDATE tbcuenta SET saldo = (saldo - %s) where idcuenta=%s",
                    monto,
                    idorigen);
            comando.executeUpdate(codigo2);
            String codigo3 = String.format("Update tbcuentatotal set saldoTotal=(select SUM(saldo) "
                    + "from tbcuenta where idcuentaTotal=%s) where idcuentatotal=%s",
                    idcuentatotalorigen,
                    idcuentatotalorigen);
            comando.executeUpdate(codigo3);
            String codigo4 = String.format("Update tbcuentatotal set saldoTotal=(select SUM(saldo) "
                    + "from tbcuenta where idcuentaTotal=%s) where idcuentatotal=%s",
                    idcuentatotaldestino,
                    idcuentatotaldestino);
            comando.executeUpdate(codigo4);

            conex.close();
        } catch (SQLException ex) {
        }
    }

    public Cuenta guardarSaldo(Cuenta cuenta) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("INSERT INTO tbcuenta (idcuentaTotal, numeroCuenta, fecha, saldo) "
                    + "VALUES ('%s', '%s', '%s', '%s')",
                    cuenta.getIdcuentaTotal(),
                    cuenta.getNumeroDeCuenta(),
                    cuenta.getFecha(),
                    cuenta.getSaldo());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return cuenta;
    }

    public void cargarCuenta(JComboBox combobox) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select nombres from tbcliente");
            ResultSet resultado = comando.executeQuery(codigo);
            while (resultado.next()) {
                combobox.addItem(resultado.getString(1));
            }
            conex.close();
        } catch (SQLException ex) {
        }
    }

    public void cargarNumeroCuenta(JComboBox combobox, int idcliente) {
        combobox.removeAllItems();
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select numeroCuenta from tbcuenta where"
                    + " idcuentaTotal='%s'",
                    idcliente);
            ResultSet resultado = comando.executeQuery(codigo);
            while (resultado.next()) {
                combobox.addItem(resultado.getString(1));
            }
            conex.close();
        } catch (SQLException ex) {
        }
    }
    
    public String generarNumCuenta() {
        int numero;
        String banco = "1234567890";
        String cadena = "";
        for (int x = 0; x < 16; x++) {
            numero = (int) (Math.random() * 8 + 1);
            int indiceAleatorio = numero;
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
            numero = 0;
        }
        return cadena;
    }

    public void cargarSaldo(JLabel label, String numeroCuenta) {
        String saldo;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select saldo from tbcuenta WHERE"
                    + " numeroCuenta='%s'",
                    numeroCuenta);
            ResultSet resultado = comando.executeQuery(codigo);
            resultado.next();
            label.setText(resultado.getString(1));
            conex.close();
        } catch (SQLException ex) {
        }
    }
    
}
