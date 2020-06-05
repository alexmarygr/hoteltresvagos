package app;

import java.util.Scanner;

public class appv2 {
    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        int anio;
        String mes;

        System.out.println("Ingrese el año:");

        anio = Teclado.nextInt();

        System.out.println("Ingrese el mes:");

        mes = Teclado.nextLine();

        switch (mes){
            case "enero":
            case "marzo":
            case "mayo":
            case "julio":
            case "agosto":
            case "octubre":
            case "diciembre":
                System.out.println("Tiene 31 dias.");
                break;

            case "febrero":
                if ( anio % 4 == 0 && anio %100 != 0)
                {   System.out.println("Tiene 29 dias.");}
                else if (anio % 400 == 0)
                {   System.out.println("Tiene 29 dias.");}
                else {
                    System.out.println("Tiene 28 dias.");
                }
                break;

            case "abril":
            case "junio":
            case "septiembre":
            case "noviembre":
                System.out.println("Tiene 30 dias.");
                break;

        }


    }
}