package app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(final String[] args) throws Exception{
        List<Persona> personas2 = new ArrayList<Persona>(); //

        Persona persona1 = new Persona();//solo una persona
        persona1 = new Persona();
        persona1.nombre = "Cecilia";

        personas2.add(persona1);//arego una persona individual a las lista de personas

        Persona persona2 = new Persona();
        persona2.nombre = "Liliana";

        personas2.add(persona2);


       for(Persona person:personas2){
           System.out.println(person.nombre);
       }

    }



}