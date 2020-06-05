package app;

import java.util.Scanner;

public class App {
    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int a,b,p,v;

        System.out.print("Ingrese Altura");
        a = Teclado.nextInt();

        System.out.print("Ingrese la base");
        b = Teclado.nextInt();

        System.out.print("Ingrese la profundidad");
        p = Teclado.nextInt();

        v = a*b*p;

        System.out.print("El volumen es: "+v);
    }
}