package clases;

public class Transferencia {

    private int idtransferencia;
    private int idcuenta;
    private String destinatario;
    private String numCuentaDestinatario;
    private int monto;

    public Transferencia(int idtransferencia, int idcuenta, String destinatario, String numCuentaDestinatario, int monto) {
        this.idtransferencia = idtransferencia;
        this.idcuenta = idcuenta;
        this.destinatario = destinatario;
        this.numCuentaDestinatario = numCuentaDestinatario;
        this.monto = monto;
    }

    public Transferencia(int idcuenta, String destinatario, String numCuentaDestinatario, int monto) {
        this.idcuenta = idcuenta;
        this.destinatario = destinatario;
        this.numCuentaDestinatario = numCuentaDestinatario;
        this.monto = monto;
    }

    public int getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(int idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNumCuentaDestinatario() {
        return numCuentaDestinatario;
    }

    public void setNumCuentaDestinatario(String numCuentaDestinatario) {
        this.numCuentaDestinatario = numCuentaDestinatario;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

}
