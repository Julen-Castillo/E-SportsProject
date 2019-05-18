/*Becoming a software engineer living in Asia*/
package bracket;

import java.util.ArrayList;


public class BRACKET {
    
    //Variable para hacer hacer dinamicos los emparejamientos dependiendo de la cantidad de equipos.  x - 2 / 2 -> donde x es el num de equipos.
    //int formulaNEquipos = (jornadaAnterior.size() + 1 -2) / 2; 
    
    private static ArrayList<Integer> partido1;
    private static ArrayList<Integer> partido2;
    private static ArrayList<Integer> partido3;
    
    //Los ArrayList de jornada almacenan los equipos en una posicion determianda para realizar los emparejamientos correctos 
    private static ArrayList<Integer> jornadaAnterior; //La jornadaAnterior es también la primera jornada
    private static ArrayList<Integer> jornadaActual;
    
    private static int posicionUltimoEquipoArray; //Numero de posicion que ocupa el ultimo equipo en el array
    private static int idEquipoEstatico; //1
    private static boolean primeraVuelta = true; //Variable para conocer si estamos en los partidos de ida o vuelta.

    public static void main(String[] args) {
        
        //Creamos la jornada inicial
        jornadaAnterior = new ArrayList();
        jornadaAnterior.add(2);
        jornadaAnterior.add(3);
        jornadaAnterior.add(4);
        jornadaAnterior.add(5);
        jornadaAnterior.add(6);

        //Tomamos el primer equipo, por lo tanto el 1. Lo tomamos como referencia y lo dejamos fuera del array, sera sobre el que realizemos todos los emparejamientos
        idEquipoEstatico = 1;
        
        //Numero de posicion que ocupa el ultimo equipo en el array
        posicionUltimoEquipoArray = jornadaAnterior.size() - 1;
        
        //Numero de equipos totales
        int numEquiposTotal = jornadaAnterior.size() + 1;
        
        //Numero de jornadas
        int numJornadas = (numEquiposTotal - 1) * 2;

        
        //Creamos el array de la siguiente jornada y realizamos los emparejamientos o partidos
        for(int i = 0; i < numJornadas; i++){
            crearArrayNextJornada();
            crearPartidos();
            //El array de la jornada Actual pasa a ser la anterior.
            jornadaAnterior = new ArrayList<>(jornadaActual);
            //Para conocer si hemos llegado al ecuador de la temporada, es decir, se ha terminado la ida.
            if((numJornadas / 2) - 1 == i){
                primeraVuelta = false;
            }
        }
    }
    
    public static void crearPartidos(){
        //Creamos los emparejamientos
        partido1 = new ArrayList();
        partido1.add(idEquipoEstatico); //primer equipo de la lista
        partido1.add(jornadaAnterior.get(posicionUltimoEquipoArray)); //lo emparejamos con el ultimo equipo del array
        System.out.println(partido1.toString()); // 1 vs 6
        
        //Set datos partido
//        if(primeraVuelta){
//            Partido oPartido = new Partido();
//            oPartido.setEquipoLocal();
//            oPartido.setIdEquipoVisitante();
//            oPartido.setoJornada(oJornada);
            //insertPartido
//        }
        
        partido2 = new ArrayList();
        partido2.add(jornadaAnterior.get(0)); //segundo equipo de la lista (es el primero del array)
        partido2.add(jornadaAnterior.get(posicionUltimoEquipoArray - 1)); //lo emparejamos contra el penultimo 
        System.out.println(partido2.toString()); // 2 vs 5
        
        partido3 = new ArrayList();
        partido3.add(jornadaAnterior.get(1)); //tercer equipo de la lista (es el segundo del array)
        partido3.add(jornadaAnterior.get(posicionUltimoEquipoArray - 2)); //lo emparejamos contra el antepenultimo
        System.out.println(partido3.toString()); // 3 vs 4
    }
    
    public static void crearArrayNextJornada(){
        //Creamos la siguiente jornada
        jornadaActual = new ArrayList();
        jornadaActual.add(jornadaAnterior.get(posicionUltimoEquipoArray)); //Pasamos el ultimo equipo de la jornada anterior a la primera posicion
        
        //Colocamos el resto de los equipos en el array
        for(int i = 0; i <= jornadaAnterior.size()- 2; i++){ //Tenemos 6 equipos. 1 equipo permanece siempre fuera del array. Otro equipo lo asignamos , por lo que solo quedan 4 equipos sobre los que iterar. -> jornadaAnterior.size()- 2
            jornadaActual.add(jornadaAnterior.get(i));
        }
        System.out.println(jornadaAnterior.toString());
        System.out.println(jornadaActual.toString());
    }

}
