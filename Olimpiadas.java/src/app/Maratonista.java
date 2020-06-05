package app;

public class Maratonista extends Deportista {
    public String categoria;
    public double marca;
    public double velocidad;
    public int energia;

    public boolean correr(){
        if (this.energia>0){
            this.velocidad = 20;
            this.energia-= 5;
            return true;
        }
        return false;        
    }
}