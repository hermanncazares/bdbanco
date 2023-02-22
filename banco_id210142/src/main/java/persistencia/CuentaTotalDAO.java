package persistencia;

import clases.Cliente;
import clases.Cuenta;
import clases.CuentaTotal;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;

public class CuentaTotalDAO {

    private ConexionBD conexion;

    public CuentaTotalDAO() {
        this.conexion = new ConexionBD();
    }

    public CuentaTotal guardar(CuentaTotal cuentaTotal) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("INSERT INTO tbcuentatotal (idcliente, saldoTotal)"
                    + "VALUES ('%s', '%s')",
                    cuentaTotal.getIdcliente(),
                    cuentaTotal.getSaldoTotal());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return cuentaTotal;
    }

    public int selectID(int idcliente) {
        int idcuentatotal;
        try {
            Resultset resultado;
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select idcuentatotal from tbcuentaTotal WHERE idcliente"
                    + "='%s'",
                    idcliente);
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            idcuentatotal = result.getInt(1);
            conex.close();
        } catch (SQLException ex) {
            return 0;
        }
        return idcuentatotal;
    }
    
     public int selectIDC(int idcliente) {
        int idcuentatotal;
        try {
            Resultset resultado;
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select idcuentatotal from tbcuenta WHERE idcuenta"
                    + "='%s'",
                    idcliente);
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            idcuentatotal = result.getInt(1);
            conex.close();
        } catch (SQLException ex) {
            return 0;
        }
        return idcuentatotal;
    }
    
   

    public void SaldoTotal(JLabel label, int id) {
        int saldoTotal;
        try {
            Resultset resultado;
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select sum(saldo) from tbcuenta WHERE idcuentaTotal="
                    + "'%s'",id);
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            saldoTotal = result.getInt(1);
            label.setText("" + saldoTotal);
            conex.close();

        } catch (SQLException ex) {
        }
    }

    public void update(Cuenta cuenta) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("Update tbcuentatotal set saldoTotal=(select SUM(saldo) "
                    + "from tbcuenta where idcuentaTotal=%s) where idcuentatotal=%s",
                    cuenta.getIdcuentaTotal(),
                    cuenta.getIdcuentaTotal());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
        }
    }
}
