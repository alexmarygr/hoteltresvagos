package app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String frase = "Hola manotas";

        int largo;
        largo = frase.length();

        System.out.println("El largo del string es "+ largo);

        char caracter;
        caracter = frase.charAt(0);

        System.out.println("el caracter en la posición cero(0) es "+ caracter);

        System.out.println("Imprimo caracter por caracter usando metodos del string");
        for (int i = 0; i < frase.length(); i++) {
            System.out.println(frase.charAt(i));
        }

        // Obteniendo el array de caracteres
        // En este caso, para determinar un ARRAY de caracteres, se usa el simbolo []
        // El simbolo [] es diferente al uso de List, ya que char al ser primitivo no
        // podemos usar
        // List<char>

        char[] caracteres;

        caracteres = frase.toCharArray();

        for(int i = 0; i < caracteres.length; i++) {
            System.out.println(caracteres[i]);
        }
        int[] numeros = new int[caracteres.length];

        for(int i = 0; i < caracteres.length; i++) {
            numeros[i] = (int) caracteres[i]; // buscamos la representacion numerica del caracter[i] en int
        }

        //foreach
        for (char c : caracteres){
            // acá la logica para cada caracter
            // se pierde la posición del caracter
            System.out.println(c);

        }

        byte[] misBytes = new byte[caracteres.length];

        for(int i = 0; i < caracteres.length; i++){
            misBytes[i] = (byte) caracteres[i];// representacion de bytes de caracteres (es lo mismo que con int)
            System.out.println(misBytes[i]);
        }

        char[] caracteresRearmados = new char[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            caracteresRearmados[i] = (char) numeros[i]; // casteo el caracter a int
            //se convierte el numero a caracter
        }

        // Ese array de caracteres lo puedo trasnformar en un string?
        // por supuesto

        String fraseRearmada;
        fraseRearmada = new String(caracteresRearmados);

        System.out.println("La frase rearmada es: " + fraseRearmada);

        // Puedo usar arrays de Objetos? Por supuesto
        // En este caso creo un array de personas de 3 posiciones
        // pero todas las posiciones estan vacias.


        Persona[] personas = new Persona[3];}//lista de personas

        public List<Persona> personas2 = new ArrayList<Persona>(); //

        // para llenarlas hay que hacer
        // en este caso en la posicion 0, ponemos una persona
        // esa persona puede ser referenciada por el array y la posicion
        // ya que cada elemento es una Persona.
        personas[0] = new Persona();
        personas[0].nombre = "Celeste";

        personas[1] = new Persona();
        personas[1].nombre = "Rosa";

        Persona persona = new Persona();//solo una persona
        persona = new Persona();
        persona.nombre = "Cecilia";

        personas2.add(persona);//arego una persona individual a las lista de personas

        persona = new Persona();
        persona.nombre = "Liliana";

        personas2.add(persona);

        // Por mas que haya llenado 2 posiciones, siempre el largo del array es 3.
        // Porque los arrays SIEMPRE se crean con un ancho fijo, ya sea un numero o una
        // funcion/propiedad
        System.out.println("El largo del array es " + personas.length);
        System.out.println("El largo la lista es " + personas2.size());

        Persona getPersonajeByName(String nombre) {
			for (Persona people : personas2) {
                if (nombre.equalsIgnoreCase(people.nombre)) {
                    return people;
               } 
            }
            // return System.out.println("Tu personaje no pertenece al mundo mágico");;
            return null;

        Persona newpersona = getPersonajeByName("Cecilia");

        System.out.println(newpersona.nombre);


        // Que usan otros lenguajes?
        // Otros lenguajes tienen tambien arrays y listas
        // pero hay otros que la notacion de array y lista es la misma
        // y la forma de acceder a la posicion es diferente
        // Si vamos a programar en C, usar arrays.
        // Puede haber challenges de java que sea trabajo con arrays.
        // y cada lenguaje tiene sus particularidades
        // en Java los string son objetos, por lo cual para compararlos se usa el .equals
        // otros lenguajes con el == es suficiente.

        System.out.println("Entonces... Listas > Arrays/Vectores");


    }
}