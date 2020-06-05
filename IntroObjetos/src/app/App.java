package app;

public class App {
    public static void main(String[] args) throws Exception {
        Ticket ticket1 = new Ticket();

        ticket1.id = 202024;
        ticket1.banda = "Blackpink";
    
        CocaCola coke1 = new CocaCola();
        coke1.nombre = "Coca Comun";

        Asistente asistente = new Asistente();
        asistente.nombre = "Laura";
        asistente.dni = 95501187;
        asistente.id = 150;         


        if (asistente.devolver(ticket1)){
         System.out.println("Pude devolver el ticket"+ ticket1.id);
        }else{
         System.out.println("Vamos a Abogado");
    }
}}
