
package clases;

public class Cuenta {
    private int idcuenta;
    private int  idcuentaTotal;
    private String numeroDeCuenta;
    private String fecha;
    private int saldo;

    public Cuenta(int idcuenta, int idcuentaTotal, String fecha, int saldo) {
        this.idcuenta = idcuenta;
        this.idcuentaTotal = idcuentaTotal;
        this.fecha = fecha;
        this.saldo = saldo;
    }

    public Cuenta(int idcuentaTotal, String numeroDeCuenta, String fecha, int saldo) {
        this.idcuentaTotal = idcuentaTotal;
        this.numeroDeCuenta = numeroDeCuenta;
        this.fecha = fecha;
        this.saldo = saldo;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getIdcuentaTotal() {
        return idcuentaTotal;
    }

    public void setIdcuentaTotal(int idcuentaTotal) {
        this.idcuentaTotal = idcuentaTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
    
    
}
