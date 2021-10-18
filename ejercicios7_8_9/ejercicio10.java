package ejercicios7_8_9;

/*Ejercicio 10:Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.
Propuesta de programa: Sencillo programa para registrar un listado de marcas de vehiculos segun el tipo de vehiculos al que pertenecen.
Ejemplo:
Motos [Honda, Yammaha, Harley Davidson]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ejercicio10 {
    //Map para guardar un listado de categorias de vehiculos con la estructura: nombre(clave) - ArrayDeMarcas(valor)
    //La declaramos static para acceder directamente sin necesidad de instancia objetos (Solo para este ejemplo)
    static HashMap<String, List<String>> mapCat = new HashMap<String, List<String>>();

    public static void main(String[] args) {


        //Inicializamos la variable de acción
        int accion = 5;

        /*Bucle para generar un selector de acciones. El usuario ha de insertar un número de los que se proponen
        Try catch para capturar la excepción de tipo de dato. Si el usuario no introduce un dato int salta la excepción
        El programa finaliza si el usuario introduce el número 5
        * */
        do{
            System.out.println("Seleccione un número para realizar las siguientes acciones: ");
            System.out.println("-------------------------ACCIONES-------------------------- ");
            System.out.println("1. Registrar marca ");
            System.out.println("2. Ver todos los vehículos");
            System.out.println("3. Salir");
            System.out.println("------------------------------------------------------------ ");
            Scanner scanner = new Scanner(System.in);
            try {
                accion = scanner.nextInt();
                if(accion < 1 || accion > 3 ){
                    System.out.println("Error: Introduzca un número acorde al menú:");
                }else {
                    switch (accion) {
                        case 1:
                            System.out.println("----REGISTRAR NUEVO VEHICULO----");
                            newVehicle();
                            break;
                        case 2:
                            System.out.println("----Listado de categorias y vehículos----");
                            for (String clave: mapCat.keySet()) {
                                List<String> modelos = mapCat.get(clave);
                                System.out.println(clave);
                                for(String modelo: modelos) {
                                    System.out.println("-" + modelo);
                                }
                            }
                            break;

                    }
                }//Fin else
            }catch (Exception e) {
                System.out.println("Error: Introduzca un número acorde al menú: " + e.getStackTrace());
            }

        }while(accion != 5);
        System.out.println("Programa finalizado.");
    }//Fin Main

    public static void newVehicle() {
        //Recibimos los datos a incluir -> Los pasamos a minúsculas para poder hacer las comparaciones sin case sensitive
        System.out.println("Introduzca un nombre de categoría para el vehículo: ");
        Scanner scanner = new Scanner(System.in);
        String nombreCategoria = scanner.next().toLowerCase();
        System.out.println("Introduzca el modelo del vehículo: ");
        String nombreMarca = scanner.next().toLowerCase();

        //Comprobar si ya existe el nombre de categoría en el mapa de categorías
        if(categoryExist(nombreCategoria, mapCat)){
            //Si existe la categoria -> buscar si ya existe un nombre de vehiculo igual en dicha categoría
            if(!marcaExist(mapCat, nombreCategoria,  nombreMarca)){
                //Si no existe la añadimos a su categoria
                addMarca(mapCat, nombreCategoria,  nombreMarca);
            }

        }else{
            //Si no existe, creamos la nueva categoría y guardamos el nuevo modelo de vehículo en ella
            addCategoria(nombreCategoria, nombreMarca, mapCat);
        }
    }

    //Método para añadir nueva marca en su categoria
    private static void addMarca(HashMap<String, List<String>> mapCat, String nombreCategoria, String nombreMarca) {
        mapCat.get(nombreCategoria).add(nombreMarca);
    }

    //Método para comprobar si exite una marca dentro de una categoria
    private static boolean marcaExist(HashMap<String, List<String>> mapCat, String nombreCategoria, String nombreMarca) {
        boolean exist = false;
        if(mapCat.get(nombreCategoria).contains(nombreMarca)) exist= true;
        System.out.println("Error: La marca " + nombreMarca + " ya existe en la categoria " + nombreCategoria);
        return exist;
    }

    /*Métdo para crear una nueva categoria
    * 1. Crear nuevo array list e iniciarlo con el nombre de la marca
    * 2. Añadir la nueva categoria al mapa de categorias (cat, modelo)
    * */
    private static void addCategoria(String nombreCategoria, String nombreVehiculo, HashMap<String, List<String>> listaCategorias) {
        //Crear nueva lista de modelos de vehiculos y añadir el nuevo vehiculo
        ArrayList<String> vh = new ArrayList<String>(1);
        vh.add(nombreVehiculo);
        //Crear nueva categoría con la nueva lista de modelos de vehiculas
        listaCategorias.put(nombreCategoria, vh);

    }

    private static boolean categoryExist(String nombre, HashMap<String, List<String>> listaCategorias) {
        boolean exist = false;
        if(listaCategorias.containsKey(nombre)) exist = true;
        return exist;
    }


}
