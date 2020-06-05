package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int a;

        Scanner Entrada = new Scanner(System.in);

        System.out.println("Ingrese altura");

        a = Entrada.nextInt();

        int b;

        System.out.println("Ingrese base");

        b = Entrada.nextInt();

        int p;

        System.out.println("Ingrese profundidad");

        p = Entrada.nextInt();

        int v;

        v = a*b*p;

        System.out.println("El volumen es " + v);


    }
}