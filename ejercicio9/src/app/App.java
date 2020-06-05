package app;

import java.util.Scanner;

public class App {
    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int x,y,z,w;

        System.out.println("Ingrese el primer numero:");

        x = Teclado.nextInt();

        System.out.println("Ingrese el segundo numero:");

        y = Teclado.nextInt();

        System.out.println("Ingrese 1 para sumar, 2 para restar o 3 para multiplicar");

        z = Teclado.nextInt();

        switch (z){
            case 1:
                w = x + y;
                System.out.println("La suma es: "+w);
                break;
            
            case 2:
                w = x - y;
                System.out.println("la resta es: "+w);
                break;

            case 3:
                w = x*y;
                System.out.println("La multiplicación es: "+w);
                break;




        }
    }
}