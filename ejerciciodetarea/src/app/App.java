package app;

import java.util.Scanner;


public class App {
    public static Scanner Teclado = new Scanner(System.in);
    public static Scanner Keyboard = new Scanner(System.in);
    public static Scanner Letra = new Scanner(System.in);
    public static void main(final String[] args) throws Exception {
        int bisiesto,menores4;
        bisiesto = 0;
        menores4 = 0;

        Double promedio,maxpromedio;
        maxpromedio = 0.0;

        String maxnombre = "nadie";

        
        System.out.println("Ingrese número de aulas:");
        final int nroaulas = Teclado.nextInt();

        for (int i = 0; i < nroaulas; i++) {
            System.out.println("Ingrese el número de la nueva aula:");
            final int aula = Teclado.nextInt();

            System.out.println("Ingrese nombre de alumno:");
            String nombre = Letra.nextLine();
            while (!nombre.equals("NADIE")) {
                System.out.println("Ingrese año de nacimiento:");
                final int anio = Keyboard.nextInt();
                if (esBisiesto(anio)){
                    bisiesto++;
                }
                
                System.out.println("Ingrese Promedio del alumno:");
                promedio = Teclado.nextDouble();
                if (promedio >= maxpromedio ){
                    maxpromedio = promedio;
                    maxnombre = nombre;

                }
                else if(promedio <= 4){
                    menores4++;
                }
                System.out.println("Ingrese el nombre del alumno: ");
                nombre = Letra.nextLine();
            }
            }
            System.out.println("La cantidad de alumnos que nacieron en años bisiestos son: "+bisiesto);
            System.out.println("La cantidad de alumnos con promedio menor a 4 es: "+menores4);
            System.out.println("El mejor promedio es "+maxpromedio+" del alumno "+maxnombre);
            
        

    }

    public static boolean esBisiesto(int year){
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }else if (year % 400 == 0){
            return true;
        }
        else {
            return false;
        }
    }}