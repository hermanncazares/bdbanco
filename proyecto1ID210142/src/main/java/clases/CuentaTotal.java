
package clases;

public class CuentaTotal {
    private int idcuentatotal;
    private int idcliente;
    private int saldoTotal;

    public CuentaTotal(int idcuentatotal, int idcliente, int saldoTotal) {
        this.idcuentatotal = idcuentatotal;
        this.idcliente = idcliente;
        this.saldoTotal = saldoTotal;
    }

    public CuentaTotal(int idcliente, int saldoTotal) {
        this.idcliente = idcliente;
        this.saldoTotal = saldoTotal;
    }

    public int getIdcuentatotal() {
        return idcuentatotal;
    }

    public void setIdcuentatotal(int idcuentatotal) {
        this.idcuentatotal = idcuentatotal;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(int saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
    
    
    
    
}
