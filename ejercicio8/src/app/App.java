package app;

import java.util.Scanner;

public class App {
    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        int anio,mes;

        System.out.println("Ingrese el año:");

        anio = Teclado.nextInt();

        System.out.println("Ingrese el mes:");

        mes = Teclado.nextInt();

        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tiene 31 dias.");
                break;

            case 2:
                if ( anio % 4 == 0 && anio %100 != 0)
                {   System.out.println("Tiene 29 dias.");}
                else if (anio % 400 == 0)
                {   System.out.println("Tiene 29 dias.");}
                else {
                    System.out.println("Tiene 28 dias.");
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tiene 30 dias.");
                break;

        }


    }
}