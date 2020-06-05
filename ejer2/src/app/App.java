package app;

import java.util.Scanner;

public class App {
    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // Importe Ingresado
        double importe;
        // total en 2 cuotas con el recargo del 5%
        double total2Cuotas;

        double cuotaEn2Pagos;
        double total6Cuotas,cuotasEn6Pagos;

        System.out.println("Ingrese el importe total");

        importe = Teclado.nextDouble();

        total2Cuotas = importe*1.05;

        cuotaEn2Pagos = total2Cuotas/2;

        total6Cuotas = importe*1.40;

        cuotasEn6Pagos = total6Cuotas/6;

        System.out.println("1 cuota de $"+importe);

        System.out.println("2 cuotas de $"+cuotaEn2Pagos+" total $"+total2Cuotas);

        System.out.println("6 cuotas de $"+cuotasEn6Pagos+" total $"+total6Cuotas);







    }
}