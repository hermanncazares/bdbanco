
package clases;

public class RetiroSinCuenta {
    private int idretirosincuenta;
    private int idcuenta;
    private String folioOperacion;
    private String contraseña;
    private String estado;
    private int monto;
    private String nombre;

    public RetiroSinCuenta(int idretirosincuenta, int idcuenta, String folioOperacion, String contraseña, String estado, int monto, String nombre) {
        this.idretirosincuenta = idretirosincuenta;
        this.idcuenta = idcuenta;
        this.folioOperacion = folioOperacion;
        this.contraseña = contraseña;
        this.estado = estado;
        this.monto = monto;
    }

    public RetiroSinCuenta(int idcuenta, String folioOperacion, String contraseña, String estado, int monto, String nombre) {
        this.idcuenta = idcuenta;
        this.folioOperacion = folioOperacion;
        this.contraseña = contraseña;
        this.estado = estado;
        this.monto = monto;
    }

    public int getIdretirosincuenta() {
        return idretirosincuenta;
    }

    public void setIdretirosincuenta(int idretirosincuenta) {
        this.idretirosincuenta = idretirosincuenta;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(String folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
