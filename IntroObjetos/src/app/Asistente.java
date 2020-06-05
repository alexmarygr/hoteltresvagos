package app;

public class Asistente {
    public int id;
    public String nombre;
    public int dni;


public void comprar(Ticket ticket){
    ticket.espectador = this;    
}
public void comprar(final Bebida bebida){
    // logica para comprar bebida
}

public boolean devolver(Ticket ticket){
    return true;
}

public void regalar(Ticket ticket, Asistente beneficiado){
    ticket.espectador = beneficiado;
}

public void asistir(){

}

public void ver(Banda banda){
    // este metodo hace que el asistente presencie la banda
}
}