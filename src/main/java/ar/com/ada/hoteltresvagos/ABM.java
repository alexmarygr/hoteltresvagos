package ar.com.ada.hoteltresvagos;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ar.com.ada.hoteltresvagos.entities.Huesped;
import ar.com.ada.hoteltresvagos.entities.Reserva;
import ar.com.ada.hoteltresvagos.excepciones.HuespedDNIException;
import ar.com.ada.hoteltresvagos.managers.HuespedManager;
import ar.com.ada.hoteltresvagos.managers.ReservaManager;

public class ABM {

    public static Scanner Teclado = new Scanner(System.in);

    protected HuespedManager ABMHuesped = new HuespedManager();
    protected ReservaManager ABMReserva = new ReservaManager();

    public void iniciarHuesped() throws Exception {

        try {

            ABMHuesped.setup();

            printOpciones();

            int opcion = Teclado.nextInt();
            Teclado.nextLine();

            while (opcion > 0) {

                switch (opcion) {
                    case 1:

                        try {
                            alta();
                        } catch (HuespedDNIException exdni) {
                            System.out.println("Error en el DNI. Indique uno valido");
                        }
                        break;

                    case 2:
                        baja();
                        break;

                    case 3:
                        modifica();
                        break;

                    case 4:
                        listar();
                        break;

                    case 5:
                        listarPorNombre();
                        break;

                    default:
                        System.out.println("La opcion no es correcta.");
                        break;
                }

                printOpciones();

                opcion = Teclado.nextInt();
                Teclado.nextLine();
            }

            // Hago un safe exit del manager
            ABMHuesped.exit();

        } catch (Exception e) {
            System.out.println("Que lindo mi sistema,se rompio mi sistema");
            throw e;
        } finally {
            System.out.println("Saliendo del sistema, bye bye...");

        }

    }

    public void alta() throws Exception {
        Huesped huesped = new Huesped();
        System.out.println("Ingrese el nombre:");
        huesped.setNombre(Teclado.nextLine());
        System.out.println("Ingrese el DNI:");
        huesped.setDni(Teclado.nextInt());
        Teclado.nextLine();
        System.out.println("Ingrese la direccion:");
        huesped.setDireccion(Teclado.nextLine());

        Reserva reserva = new Reserva();

        BigDecimal importeReserva = new BigDecimal(1000);

        reserva.setImporteReserva(importeReserva); //Forma 1
       
        reserva.setImporteTotal(new BigDecimal(3000)); //Forma 2

        reserva.setImportePagado(new BigDecimal(0));

        reserva.setFechaReserva(new Date()); //Fecha actual

        reserva.setImporteFaltante(new BigDecimal(0));

        System.out.println("Ingrese la fecha de ingreso(dd/MM/yy)");

        Date fechaIngreso = null;
        Date fechaEgreso = null;

        DateFormat dFormat = new SimpleDateFormat("dd/MM/yy");

        //Alternativa de leer fecha con try catch
        try{
            fechaIngreso = dFormat.parse(Teclado.nextLine());

        } catch(Exception ex){
            System.out.println("Ingreso una fecha invalida.");
            System.out.println("Vuelva a e empezar");
            return;
        }

        //Alternativa de leer fecha a los golpes(puede tirar una excepcion)
        System.out.println("Ingrese la fecha de egreso(dd/MM/yy)");
        fechaEgreso = dFormat.parse(Teclado.nextLine());
        
        reserva.setFechaIngreso(fechaIngreso); 
        reserva.setFechaEgreso(fechaEgreso); //por ahora 1 dia.
        reserva.setTipoEstadoId(1); //En mi caso, 20 significa pagado.
        reserva.setHuesped(huesped); //Esta es la relacion bidireccional
        
        //Actualizo todos los objeto
        ABMHuesped.create(huesped);                 

        /*
         * Si concateno el OBJETO directamente, me trae todo lo que este en el metodo
         * toString() mi recomendacion es NO usarlo para imprimir cosas en pantallas, si
         * no para loguear info Lo mejor es usar:
         * System.out.println("Huesped generada con exito.  " + huesped.getHuespedId);
         */

        System.out.println("Huesped generada con exito.  " + huesped);

    }

    public void baja() {
        System.out.println("Ingrese el ID de Huesped que desea eliminar:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Huesped huespedEncontrado = ABMHuesped.read(id);

        if (huespedEncontrado == null) {
            System.out.println("Huesped no encontrado.");

        } else {

            try {

                ABMHuesped.delete(huespedEncontrado);
                System.out
                        .println("El registro del huesped " + huespedEncontrado.getHuespedId() + " ha sido eliminado.");
            } catch (Exception e) {
                System.out.println("Ocurrio un error al eliminar una huesped. Error: " + e.getCause());
            }

        }
    }

    public void bajaPorDNI() {
        System.out.println("Ingrese el DNI de Huesped que desea eliminar:");
        int dni = Teclado.nextInt();
        Huesped huespedEncontrado = ABMHuesped.readByDNI(dni);

        if (huespedEncontrado == null) {
            System.out.println("Huesped no encontrado.");

        } else {
            ABMHuesped.delete(huespedEncontrado);
            System.out.println("El registro del DNI " + huespedEncontrado.getDni() + " ha sido eliminado.");
        }
    }

    public void modifica() throws Exception {
        // System.out.println("Ingrese el nombre de la huesped a modificar:");
        // String n = Teclado.nextLine();

        System.out.println("Ingrese el ID de la huesped a modificar:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Huesped huespedEncontrado = ABMHuesped.read(id);

        if (huespedEncontrado != null) {

            // RECOMENDACION NO USAR toString(), esto solo es a nivel educativo.
            System.out.println(huespedEncontrado.toString() + " seleccionado para modificacion.");

            System.out.println(
                    "Elija qué dato de la huesped desea modificar: \n1: nombre, \n2: DNI, \n3: domicilio, \n4: domicilio alternativo");
            int selecper = Teclado.nextInt();

            switch (selecper) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre:");
                    Teclado.nextLine();
                    huespedEncontrado.setNombre(Teclado.nextLine());

                    break;
                case 2:
                    System.out.println("Ingrese el nuevo DNI:");
                    Teclado.nextLine();
                    huespedEncontrado.setDni(Teclado.nextInt());
                    Teclado.nextLine();

                    break;
                case 3:
                    System.out.println("Ingrese el nuevo direccion:");
                    Teclado.nextLine();
                    huespedEncontrado.setDireccion(Teclado.nextLine());

                    break;
                case 4:
                    System.out.println("Ingrese el nuevo direccion:");
                    Teclado.nextLine();
                    huespedEncontrado.setDireccion(Teclado.nextLine());

                    break;

                default:
                    break;
            }

            // Teclado.nextLine();

            ABMHuesped.update(huespedEncontrado);

            System.out.println("El registro de " + huespedEncontrado.getNombre() + " ha sido modificado.");

        } else {
            System.out.println("Huesped no encontrado.");
        }

    }

    public void listar() {

        List<Huesped> todos = ABMHuesped.buscarTodos();
        for (Huesped c : todos) {
            mostrarHuesped(c);
        }
    }

    public void listarPorNombre() {

        System.out.println("Ingrese el nombre:");
        String nombre = Teclado.nextLine();

        List<Huesped> huespedes = ABMHuesped.buscarPor(nombre);
        for (Huesped huesped : huespedes) {
            mostrarHuesped(huesped);
        }
    }

    public void mostrarHuesped(Huesped huesped) {

        System.out.println(" Id: " + huesped.getHuespedId() + " Nombre: " + huesped.getNombre()
        + " DNI: " + huesped.getDni() + " Direccion: " + huesped.getDireccion());

    }

    public static void printOpciones() {
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("1. Para agregar un huesped.");
        System.out.println("2. Para eliminar un huesped.");
        System.out.println("3. Para modificar un huesped.");
        System.out.println("4. Para ver el listado.");
        System.out.println("5. Buscar un huesped por nombre especifico(SQL Injection)).");
        System.out.println("0. Para terminar.");
        System.out.println("");
        System.out.println("=======================================");
    }

    public static void ImprimirOpcionesReserva() {
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("1. Para ver el listado.");
        System.out.println("2. Buscar una reserva por id reserva.");
        System.out.println("3. Buscar una reservas por nombre del huesped.");
        System.out.println("0. Para terminar.");
        System.out.println("");
        System.out.println("=======================================");
    }

    public void listarReserva(){
        List<Reserva> todas = ABMReserva.reservaBuscarTodos();
        for (Reserva r : todas){
            mostrarReserva(r);
        }
    }

    public void mostrarReserva(Reserva reserva) {

        System.out.println("Reserva nro: " + reserva.getReservaId() + " de " + reserva.getHuesped().getNombre() + " Fecha Ingreso: " + reserva.getFechaIngreso()
        + " Fecha Egreso: " + reserva.getFechaEgreso() + " Importe Total: " + reserva.getImporteTotal()
        + " Importe Pagado: " + reserva.getImportePagado());

    }

    public void iniciarReserva() throws Exception {

        try {

            ABMReserva.setup();

            ImprimirOpcionesReserva();

            int opcion = Teclado.nextInt();
            Teclado.nextLine();

            while (opcion > 0) {

                switch (opcion) {
                    case 1:

                        listarReserva();
                        break;

                    case 2:
                        buscarReservaPorId();
                        break;

                    case 3:
                        buscarReservaPorNombreHuesped();
                        break;

                    default:
                        System.out.println("La opcion no es correcta.");
                        break;
                }

                ImprimirOpcionesReserva();

                opcion = Teclado.nextInt();
                Teclado.nextLine();
            }

            // Hago un safe exit del manager
            ABMReserva.exit();

        } catch (Exception e) {
            System.out.println("Que lindo mi sistema,se rompio mi sistema");
            throw e;
        } finally {
            System.out.println("Saliendo del sistema, bye bye...");

        }

    }

    public void buscarReservaPorId() {

        System.out.println("Ingrese reservaId:");
        int numero = Teclado.nextInt();

        List<Reserva> reservas = ABMReserva.buscarPorId(numero);
        for (Reserva r : reservas) {
            mostrarReserva(r);
        }
    }

    public void buscarReservaPorNombreHuesped() {

        System.out.println("Ingrese el nombre del huesped:");
        String nombre = Teclado.nextLine();

        List<Reserva> reservas = ABMReserva.buscarReservaPorNombreDeHuesped(nombre);
        for (Reserva r : reservas) {
            mostrarReserva(r);
        }
    }
}