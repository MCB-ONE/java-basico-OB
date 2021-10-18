package ejercicio;

import java.sql.Date;

public class Usuario implements AccionesLog {
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String fechaNacimiento;
    private boolean log = false;

    /*Constructores*/
    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String email, String password, String fechaNacimiento, boolean log) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.log = log;
    }

    /*Getters y setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    /*Métodos implementados de AccionesLog*/
    @Override
    public boolean logIn(String nombre, String password) {
        if(this.log == false){
            this.log = true;
            System.out.println("Bienvenido " + this.nombre + ". Ha iniciado sesión correctamente.");
        };

        return this.log;
    }

    @Override
    public boolean logOut() {
        if(this.log == true){
            this.log = false;
            System.out.println("Adiós " + this.nombre + ". Sesión cerrada.");
        };
        return this.log;
    }
}