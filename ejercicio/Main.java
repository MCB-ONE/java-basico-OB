package ejercicio;

public class Main {
    public static void main(String[] args) {
        Usuario usuarioPrueba = new Usuario("Pedro", "Ramírez", "pedrito.rami.usuario@gmail.com",  "pdrto1238", "12-09-90", false);
        Administrador adminPrueba = new Administrador("Manolo", "Cruzado", "manolo.admin@admin.com", "manolcruz345", "14-01-86", false, "ALTO");

        //Llamada a los métodos de cada objeto
        System.out.println("--Usuario--");
        usuarioPrueba.logIn(usuarioPrueba.getNombre(), usuarioPrueba.getPassword());
        usuarioPrueba.logOut();
        System.out.println("--Admin--");
        adminPrueba.logIn(adminPrueba.getNombre(), adminPrueba.getPassword(), adminPrueba.getNivelSeguridad());
        adminPrueba.logOut();
    }
}
