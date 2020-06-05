package app;

import java.util.Scanner;

public class App {
    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int a,b,suma,resta,mult;
    
        System.out.println("Ingrese el primer numero");

        a = Teclado.nextInt();

        System.out.println("Ingrese el segundo numero");

        b = Teclado.nextInt();

        suma = a + b;

        resta = a - b;

        mult = a*b;

        System.out.println("La suma es: "+suma);

        System.out.println("la resta es: "+resta);

        System.out.println("la multiplicacion es: "+mult);
        
    }
}