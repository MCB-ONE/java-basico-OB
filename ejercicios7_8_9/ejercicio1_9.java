package ejercicios7_8_9;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class ejercicio1_9 {

    public static void main(String[] args) {

        //Ejercicio 1: Invertir string
        System.out.println("------------------Ejercicio 1: Invertir string ------------------");
        String texto = "Mundo Mi0";
        System.out.println(reverse(texto));

        //Ejercicio 2: Mostrar valores de un array de strings
        System.out.println("------------------Ejercicio 2: Mostrar valores de un array de strings ---------------------");
        String[] arrayTexto = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        recorrerArrayStrings(arrayTexto);

        //Ejercicio 3: Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.
        System.out.println("------------------Ejercicio 3: Array Bidimensioanl ---------------------");
        int[][] arrayBidimensional = {{1, 2, 3}, {11, 12, 13}, {21, 22, 23}};
        recorrerArrayBidimensional(arrayBidimensional);

        //Ejercicio 4:Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.
        System.out.println("------------------Ejercicio 4: Eliminar elementos de un vector ---------------------");
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println("Vector inicial: " + vector);
        deleteVectorElements(vector);

        System.out.println("Vector depsués de borrar el elemneto 2 y 3: " + vector);

        //Ejercicio 5: Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
        //Respuesta ejercicio 4: Habría un gran coste de rendimiento. Dado que la capacidad por defecto es 10 y cada vez que se supera dicha capacidad ha de realizarse una copia del vector actual en un nuevo vector de +10 capacidad. Esto quiere decir que se tendrían que hacer 1000/10 copias. Son 100 copias cada una con un incremento de datos +10 (10, 20, 30, etc).

        //Ejercicio 6: Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.
        System.out.println("------------------Ejercicio 6: ArrayList y LinkedList---------------------");
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Elemento 1");
        arrayList.add("Elemento 2");
        arrayList.add("Elemento 3");
        arrayList.add("Elemento 4");

        LinkedList<String> linkedList = new LinkedList<>(arrayList);

        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("Contendio del elemento " + i + " del arrayList: " + arrayList.get(i));
            System.out.println("Contendio del elemento " + i + " del linkedList: " + linkedList.get(i));
            System.out.println("----");
        }

        //Ejercicio 7: Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación, con otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final. Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
        System.out.println("------------------Ejercicio 7: ArrayList y bucles---------------------");
        ArrayList<Integer> arrayListEnteros = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if (i%2 != 0) arrayListEnteros.add(i+1);
        }
        System.out.println("Mostrando el ArrayList creado desde un búcle solo con los números inpares del 1 al 10");
        for (Integer arrayListEntero : arrayListEnteros) {
            System.out.println(arrayListEntero);
        }

        //Ejercicio 8: Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso: "Demo de código".
        System.out.println("------------------Ejercicio 8: Gestión de errores---------------------");
        DividePorCero( 5, 0);

        //Ejercicio 9: Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
        System.out.println("------------------Ejercicio 9: Leer y copiar ficheros ---------------------");
        try{
            InputStream fileIn = new FileInputStream("src/ejercicios7_8_9/pruebaIn.txt");
            PrintStream toCopyFile= new PrintStream(String.valueOf("src/ejercicios7_8_9/pruebaOut.txt"));
            try{
                byte[] ogFileData = fileIn.readAllBytes();
                fileCopy(ogFileData , toCopyFile);
            }catch(IOException e){
                System.out.println("Imposible LEER fichero" + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo NO ENCONTRADO..." + e.getMessage());
        }

        //Ejercicio 10: //Se encuentra separado en su propia clase ejercicio 10
        System.out.println("------------------Ejercicio 10: Propon un programa ---------------------");
        System.out.println("Ejercicio separado en la clase ejercicio 10");
    }




    //Función del ejercicio 1
    public static String reverse(String texto) {
        /** Invertir string: Solución con bucle
         *  1. Recorrer texto caracter x caracter de forma invertida
         *  1.1. En cada iteración ir concatenando el valor de cada posicioón en una nueva variable stirng
         *  2. Devolver neuvo string
         * */
        int tam = texto.length();

        //Recorrer array inverso
        String textoInvertido = "";
        for(int i = texto.length() - 1; i >= 0 ; i--){
            textoInvertido += texto.charAt(i);
        }
        return textoInvertido;
    }

    //Función del ejercicio 2
    public static void recorrerArrayStrings(String[] arrayStrings ){
        for(int i =0; i < arrayStrings.length; i++){
            System.out.println(arrayStrings[i]);
        }
    }

    //Función del ejercicio 3
    public static void recorrerArrayBidimensional(int[][] arrayBidimensional ){
        for(int i =0; i < arrayBidimensional.length; i++){
            for(int j =0; j < arrayBidimensional[i].length; j++){
                System.out.println("Posicion " + i + " " + j + " : " + arrayBidimensional[i][j] );
            }
        }
    }

    //Función ejercicio 4
    public static Vector<Integer> deleteVectorElements(Vector<Integer> vector) {

        vector.removeElementAt(1);
        vector.removeElementAt(1);
        return vector;
    }

    //Función ejercicio 8
    private static void DividePorCero(int numero, int zero) {
        try {
            //Bloque try: Evaluamos el código susceptible a errores
            int resultado = numero/zero;
        } catch (ArithmeticException exception){
            //Bloque catch: Instrucciones a ejecutar si sucede la exception/error
            exception.printStackTrace(); //este método de la clase exception dice qué sucedió y en qué parte del código sucedió.
            System.out.println("Fin: Intentando divididr entre 0. Esto no se puede hacer");

        } finally{
            System.out.println("Demo de código");
        }
    }

    /*Función del ejercicio 9 */
    private static void fileCopy( byte[] ogFileData, PrintStream toCopyFile) {
        try {
            toCopyFile.write(ogFileData);
        }catch (IOException e){
            System.out.println("Imposible copiar archivo" + e.getMessage());
        }

        System.out.println(toCopyFile);
    }


}
