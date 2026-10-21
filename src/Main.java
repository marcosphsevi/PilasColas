import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //EJERCICIO 1

        Scanner sc = new Scanner(System.in);
        Pila<Character> pila = new Pila<>();
        String input;
        System.out.println("Ejercicio 1: ");

        while (true) {
            System.out.println("Escribe una línea de texto");
            input = sc.nextLine();
            if (input.isEmpty()){
                System.out.println("Has escrito una línea de texto vacía, inténtalo otra vez.");
            }else {
                break;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            pila.push(input.charAt(i));
        }

        input = "";

        while (!pila.isEmpty()) {
            input += pila.pop();
        }

        System.out.println("Cadena inversa: \"" + input + "\"");

        //EJERCICIO 2

        Cola<String> cola = new Cola<>();
        boolean salir = false;
        System.out.println("Ejercicio 2: ");
        do {
            while (true) {
                System.out.println("Elije una opción:\n" +
                        "1) Llegada\n" +
                        "2) Atender\n" +
                        "3) Mostrar cola\n" +
                        "4) Salir");
                input = sc.nextLine();
                if (!Depurar.depuracionEnteros(input)) {
                    System.err.println("Tienes que introducir un número entero");
                } else {
                    break;
                }
            }
            switch (Integer.parseInt(input)) {
                case 1:
                    while (true) {
                        System.out.println("Introduce el Nombre de la persona que acaba de llegar a la cola: ");
                        input = sc.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("No puedes dejar el campo vacío.");
                        } else {
                            cola.enqueue(input);
                            break;
                        }
                    }
                    break;
                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("La cola está vacía");
                    } else {
                        System.out.println("Has atendido a \"" + cola.dequeue() + "\".");
                    }
                    break;
                case 3:
                    if (!cola.isEmpty()) {
                        System.out.println("Personas en la cola: ");
                        String nombre;
                        Cola<String> copiaCola = new Cola<>();
                        while (!cola.isEmpty()) {
                            nombre = cola.dequeue();
                            System.out.print(nombre);
                            copiaCola.enqueue(nombre);
                            if (!cola.isEmpty()) {
                                System.out.print(", ");
                            } else {
                                System.out.println(".");
                            }
                        }
                        while (!copiaCola.isEmpty()) {
                            cola.enqueue(copiaCola.dequeue());
                        }
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.err.println("Tienes que introducir un número entre 1 y 4");
                    break;
            }
        } while (!salir);

        //Ejercicio 3

        System.out.println("Ejercicio 3");

        Cola<Character> colaPalindromo = new Cola<>();
        Pila<Character> pilaPalindromo = new Pila<>();

        while (true) {
            System.out.println("Escribe una palabra, para comprobar si es palíndroma o no.");
            input = sc.nextLine().toLowerCase().trim();
            if (input.isEmpty()){
                System.out.println("No has introducido ninguna palabra, inténtalo otra vez.");
            }else {
                break;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            colaPalindromo.enqueue(input.charAt(i));
            pilaPalindromo.push(input.charAt(i));
        }

        String palabra1 = "", palabra2 = "";

        while (!colaPalindromo.isEmpty()) {
            palabra1 += colaPalindromo.dequeue();
            palabra2 += pilaPalindromo.pop();
        }

        if (palabra1.equals(palabra2)){
            System.out.println("La palabra " + input + " es palíndroma.");
        }else{
            System.out.println("La palabra " + input + " no es palíndroma.");
        }

        //Ejercicio 4

        Pila<Integer> pilaBinaria = new Pila<>();

        System.out.println("Ejercicio 4");


        while (true){
            System.out.println("Introduce un número entero para pasarlo a binario.");
            input = sc.nextLine();
            if (!Depurar.depuracionEnteros(input)){
                System.out.println("Tienes que introducir un número entero, inténtalo otra vez.");
            }else {
                if (Integer.parseInt(input) < 0){
                    System.out.println("Tienes que introducir un número positivo o igual a 0");
                }else{
                    break;
                }
            }
        }

        int numero = Integer.parseInt(input);

        while (numero > 0){
            pilaBinaria.push(numero % 2);
            numero /= 2;
        }

        String num = "";
        while (!pilaBinaria.isEmpty()){
            num += pilaBinaria.pop();
        }

        System.out.println("El número " + input + " en binario es " + num);
    }
}
