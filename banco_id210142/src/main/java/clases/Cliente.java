package clases;

public class Cliente {
    private int idcliente;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String edad;
    private String domicilio;

    public Cliente(int idcliente, String nombres, String apellidos, String fechaNacimiento, String edad, String domicilio) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.domicilio = domicilio;
    }

    public Cliente(String nombres, String apellidos, String fechaNacimiento, String edad, String domicilio) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.domicilio = domicilio;
    }

    public Cliente(String nombres) {
        this.nombres = nombres;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    
    
    
    
}
