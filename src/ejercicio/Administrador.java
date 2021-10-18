package ejercicio;

public class Administrador implements AccionesLog{
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String fechaNacimiento;
    private boolean log = false;
    private String nivelSeguridad;

    /*Constructores*/
    public Administrador() {
    }

    public Administrador(String nombre, String apellidos, String email, String password, String fechaNacimiento, boolean log, String nivelSeguridad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.log = log;
        this.nivelSeguridad = nivelSeguridad;
    }
    /*Getters y setters*/

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNivelSeguridad() {
        return nivelSeguridad;
    }

    /*Métodos implementados de AccionesLog*/
    @Override
    public boolean logIn(String nombre, String password) {
        return this.log;
    }
    //Sobrecarga del método login heredado de la interfaz
    public boolean logIn(String nombre, String password, String nivelSeguridad) {
        if(this.log == false){
            this.log = true;
            System.out.println("Bienvenido " + this.nombre + ". SU NIVEL DE SEGURIDAD ES: " + nivelSeguridad + ". Ha iniciado sesión correctamente.");
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
