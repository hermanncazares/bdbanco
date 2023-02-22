package persistencia;

import clases.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    private ConexionBD conexion;

    public ClienteDAO() {
        this.conexion = new ConexionBD();
    }

    public Cliente update(Cliente cliente) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("UPDATE tbcliente SET nombres = '%s', apellidos = '%s', fechaNacimiento = '%s', edad = '%s', domicilio = '%s'"
                    + "WHERE  idcliente= '%s';",
                    cliente.getNombres(),
                    cliente.getApellidos(),
                    cliente.getFechaNacimiento(),
                    cliente.getEdad(),
                    cliente.getDomicilio(),
                    cliente.getIdcliente());
                    
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return cliente;
    }

    public Cliente guardar(Cliente cliente) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("INSERT INTO tbcliente (nombres, apellidos, fechaNacimiento, edad, domicilio)"
                    + "VALUES ('%s', '%s', '%s', '%s', '%s')",
                    cliente.getNombres(),
                    cliente.getApellidos(),
                    cliente.getFechaNacimiento(),
                    cliente.getEdad(),
                    cliente.getDomicilio());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            return null;
        }
        return cliente;
    }

    public int selectID(Cliente cliente) {
        int idcliente;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select idcliente from tbcliente WHERE nombres"
                    + "='%s'",
                    cliente.getNombres());
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            idcliente = result.getInt(1);
            conex.close();
        } catch (SQLException ex) {
            return 0;
        }
        return idcliente;
    }
    public String selectApellidos(int idcliente, String opcion) {
        String apellidos="";
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select %s from tbcliente WHERE idcliente"
                    + "=" + idcliente, opcion
            );
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            apellidos = result.getString(1);
            conex.close();
        } catch (SQLException ex) {
        }
        return apellidos;
    }


    
     public int selectNombre(Cliente cliente) {
        int idcliente;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo = String.format("select idcliente from tbcliente WHERE nombres"
                    + "='%s'",
                    cliente.getNombres());
            ResultSet result = comando.executeQuery(codigo);
            result.next();
            idcliente = result.getInt(1);
            conex.close();
        } catch (SQLException ex) {
            return 0;
        }
        return idcliente;
    }

}
