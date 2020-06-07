
package ar.com.ada.hoteltresvagos;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        

        System.out.println("Elegir 1. Huesped");
        System.out.println("Elegir 2. Reserva");
        int opcion = Teclado.nextInt();
        Teclado.nextLine();

        switch (opcion){
            case 1:
                ABM miABM = new ABM();
                miABM.iniciarHuesped();
                break;
            case 2:
                ABM miABM2 = new ABM();
                miABM2.iniciarReserva();
                break;

        }

        
    

    }
}
