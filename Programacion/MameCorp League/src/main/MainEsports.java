package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;
import modeloDB.*;
import vistas.*;



public class MainEsports {

    private static VentanaCategoria vCategoria;
    private static VentanaAdministradores vAdmin;
    private static VentanaModUsuarios vUsuario;
    private static Connection con;
    
    private static Sesion oSesion;
    private static Jugador oJugador;
    
    //VARIABLES PARA LA CREACION DE LOS PARTIDOS
    private static ArrayList<Equipo> listaEquipos;
    //Los ArrayList de partido almacenan los objetos de los 2 equipos enfrentados
    private static ArrayList<Equipo> partido1;
    private static ArrayList<Equipo> partido2;
    private static ArrayList<Equipo> partido3;
    //Los ArrayList de jornada almacenan los objetos de equipo en una posicion determianda para realizar los emparejamientos correctos 
    private static ArrayList<Equipo> jornadaAnterior; //La jornadaAnterior es también la primera jornada
    private static ArrayList<Equipo> jornadaActual;
    private static Equipo oEquipoEstatico; //Tomamos el primer equipo de la BD como referencia y lo dejamos fuera del array, sera sobre el que realizemos todos los emparejamientos
    private static int posicionUltimoEquipoArray; //Numero de posicion que ocupa el ultimo equipo en el array
    private static boolean primeraVuelta = true; //Variable para conocer si estamos en los partidos de ida o vuelta.
    private static boolean EquipoEstaticoEsLocal = true; //Variable para conocer si estamos en los partidos de ida o vuelta.
    private static int numeroJornada = 1; //Variabla para trackear en que jornada nos encontramos
    private static Partido oPartido;
    private static Jornada oJornada;
    private static Liga oLiga;
    
<<<<<<< HEAD
    public static void main(String[] args) throws SQLException {
        
        //La linea de abajo está comentada porque todavia no está implementado el login
       // ControladorVista.mostrarVentanaVisualizarLiga();
       GenericoDB.conectar();
          con =  GenericoDB.getCon();
          if(con != null)
         ControladorVista.mostrarLogin();
          //ControladorVista.mostrarVentanaAdministradores();
     

=======
    
    
    
    public static void main(String[] args) throws SQLException, Exception {
    
        //La linea de abajo está comentada porque todavia no está implementado el login
        // ControladorVista.mostrarVentanaVisualizarLiga();
        GenericoDB.conectar();
        con =  GenericoDB.getCon();
        if(con != null){           
            crearRoundRobinEmparejamientos();
            ControladorVista.mostrarLogin();
        }
>>>>>>> development
    }
    
    public static void consultarEquipos() throws Exception{
        EquipoDB equipoDB = new EquipoDB();

        ArrayList<Equipo> listaEquipos = equipoDB.consultarTodos();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }   
    }
    
    public static ArrayList consultarEquipoSinPresidente() throws Exception{
        EquipoDB equipoDB = new EquipoDB();
        ArrayList<Equipo> listaEquipos = equipoDB.consultarEquipoSinPresidente();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }   
        
        return listaEquipos;
    }


    public static int insertarEquipos(String nombre,int presupuesto,int puntos) throws Exception{
    
        Equipo e = new Equipo(nombre,presupuesto,puntos);
        EquipoDB equipoDB = new EquipoDB();
        
        return equipoDB.insertarEquipo(e);  

    }
    public static int insertarAdministrador(String nombre,String password) throws Exception{
    
        Sesion oSesion = new Sesion(nombre,password);
        SesionDB sesionDB = new SesionDB();
        
        return SesionDB.insertarAdministrador(nombre,password);
    
    }
    /* public static int insertarPresidente(String nombrePresidente, String apellidoPresidente,Equipo equipoPresidente) throws Exception {
       
        Presidente p = new Presidente(nombrePresidente,apellidoPresidente,equipoPresidente);
        PresidenteDB presidenteDB = new PresidenteDB();
       
        return presidenteDB.insertarPresi(p);
  
    }
      */

    public static Sesion comprobarLogin(String nombre,String password) throws Exception{
    
        oSesion = SesionDB.consultarUsuario(nombre,password);
        
        return oSesion;
    }
    
    public static Jugador darBajaJugador(String nick) throws Exception{
       oJugador = JugadorDB.consultarJugador(nick);
       if (oJugador == null){
           
           return null;
       }
       else {
           String jugador = oJugador.getNickname();
       }
       
       return oJugador;    
    }
    
    
    public static void crearRoundRobinEmparejamientos() throws Exception{
        //Obtenemos todos los equipos de la liga
        listaEquipos = EquipoDB.consultarTodos();
        
        //Eliminamos el primer equipo del array devuelto por la base de datos. Va a ser el equipo de referencia sobre el que construimos el algoritmo.
        oEquipoEstatico = new Equipo();
        oEquipoEstatico = listaEquipos.remove(0);


        //Creamos la jornada inicial. Añadimos al ArrayList jornada los equipos(objeto) participantes en la liga. (Exceptuando el primero -> oEquipoEstatico).
        jornadaAnterior = new ArrayList();
        for(int i = 0; i < listaEquipos.size(); i++){
            jornadaAnterior.add(listaEquipos.get(i));
        }

        //Posicion que ocupa el ultimo equipo en el array
        posicionUltimoEquipoArray = jornadaAnterior.size() - 1;

        //Numero de equipos totales
        int numEquiposTotal = jornadaAnterior.size() + 1;

        //Numero de jornadas
        int numJornadas = (numEquiposTotal - 1) * 2;


        //Creamos el array de cada jornada y realizamos los emparejamientos o partidos de cada jornada
        for(int i = 0; i < numJornadas; i++){
            crearArrayNextJornada();
            crearPartidos();
            //El array de la jornada Actual pasa a ser la anterior.
            jornadaAnterior = new ArrayList<>(jornadaActual);
            //Para conocer si hemos llegado al ecuador de la temporada, es decir, se ha terminado la ida.
            if((numJornadas / 2) - 1 == i){
                primeraVuelta = false;
            }
            //Pasamos a la siguiente jornada por lo que actualizamos el numero de jornada en el que nos encontramos.
            System.out.println("FIN DE LA JORNADA NUMEROOOOOOOO: " + numeroJornada);
            numeroJornada++;
        }
    }
    
    
    
    public static void crearArrayNextJornada(){
        //Creamos la siguiente jornada, rotando las posiciones de los equipos en el array
        jornadaActual = new ArrayList();
        jornadaActual.add(jornadaAnterior.get(posicionUltimoEquipoArray)); //Pasamos el ultimo equipo de la jornada anterior a la primera posicion
        
        //Colocamos el resto de los equipos en el array
        for(int i = 0; i <= jornadaAnterior.size()- 2; i++){ //Tenemos 6 equipos. 1 equipo permanece siempre fuera del array. Otro equipo lo asignamos a la primera posicion del array jornada actual(rotacion), por lo que solo quedan 4 equipos sobre los que iterar. -> jornadaAnterior.size()- 2
            jornadaActual.add(jornadaAnterior.get(i));
        }
        
        //Array de la jornada anterior
        System.out.println("Jornada anterior");
        for(int i = 0; i < listaEquipos.size(); i++){
            System.out.println(jornadaAnterior.get(i).getIdEquipo());
        }
        //Array de la nueva jornada
        System.out.println("Jornada actual");
        for(int i = 0; i < listaEquipos.size(); i++){
            System.out.println(jornadaActual.get(i).getIdEquipo());
        }     
    }
    

    public static void crearPartidos() throws Exception{
        //Creamos los emparejamientos
        
        //PRIMER PARTIDO
        partido1 = new ArrayList();
        partido1.add(oEquipoEstatico); //primer equipo de la lista
        partido1.add(jornadaAnterior.get(posicionUltimoEquipoArray)); //lo emparejamos con el ultimo equipo del array
        System.out.println(partido1.get(0).getNombre() + " VS " + partido1.get(1).getNombre()); // 1 vs 6
        
        
        oPartido = new Partido();
        oJornada = new Jornada();
        
        //SET DATOS PARTIDO 1
        //Para el primer partido de cada jornada nos es irrelevante saber si corresponde a la ida o la vuelta.
        if(EquipoEstaticoEsLocal){
            oPartido.setEquipoLocal(partido1.get(0));
            oPartido.setEquipoVisitante(partido1.get(1));
            //Obtenemos el objeto de la liga para meterlo dentro del objeto jornada
            oLiga = LigaDB.getObjetoLiga();
            //Obtenemos el objeto de la jornada actual
            oJornada = JornadaDB.getObjetoJornada(numeroJornada);
            oJornada.setoLiga(oLiga);
            oPartido.setoJornada(oJornada);
            //Asignamos un ganador aleatorio
            int winner = randomWinner();
            oPartido.setEquipoVencedor(partido1.get(winner));            
            System.out.println("INSERTO LA JORNADA NUMEROOOOOO: " + oPartido.getoJornada().getIdJornada());
            //Insert partido
            PartidoDB.insertarPartido(oPartido);

            //Cambiamos el valor del bolean EquipoEstaticoEsLocal. Si esta jornada ha sido local la siguiente será visitante o viceversa. 
            EquipoEstaticoEsLocal = !EquipoEstaticoEsLocal;
        }
        else{
            oPartido.setEquipoLocal(partido1.get(1));
            oPartido.setEquipoVisitante(partido1.get(0));
            //getoJornada where id = numeroJornada
            //oPartido.setoJornada(oJornada);
            //listaPartidos.add(oPartido);
            //insert lista partidos
            //Cambiamos el valor del bolean EquipoEstaticoEsLocal. Si esta jornada ha sido local la siguiente será visitante o viceversa. 
            EquipoEstaticoEsLocal = !EquipoEstaticoEsLocal;
        }

        
        //SEGUNDO PARTIDO
        partido2 = new ArrayList();
        partido2.add(jornadaAnterior.get(0)); //segundo equipo de la lista (es el primero del array)
        partido2.add(jornadaAnterior.get(posicionUltimoEquipoArray - 1)); //lo emparejamos contra el penultimo 
        System.out.println(partido2.get(0).getNombre() + " VS " + partido2.get(1).getNombre()); // 2 vs 5
        
        oPartido = new Partido();
        
        //SET DATOS PARTIDO 2
        if(primeraVuelta){
            oPartido.setEquipoLocal(partido2.get(1));
            oPartido.setEquipoVisitante(partido2.get(0));
            //getoJornada where id = numeroJornada
            //oPartido.setoJornada(oJornada);
            //listaPartidos.add(oPartido);
            //insert lista partidos
        }
        else{
            oPartido.setEquipoLocal(partido2.get(0));
            oPartido.setEquipoVisitante(partido2.get(1));
            //getoJornada where id = numeroJornada
            //oPartido.setoJornada(oJornada);
            //listaPartidos.add(oPartido);
            //insert lista partidos
        }
        
        partido3 = new ArrayList();
        partido3.add(jornadaAnterior.get(1)); //tercer equipo de la lista (es el segundo del array)
        partido3.add(jornadaAnterior.get(posicionUltimoEquipoArray - 2)); //lo emparejamos contra el antepenultimo
        System.out.println(partido3.get(0).getNombre() + " VS " + partido3.get(1).getNombre()); // 3 vs 4
        
        oPartido = new Partido();
        
        //SET DATOS PARTIDO 3
        if(primeraVuelta){
            oPartido.setEquipoLocal(partido3.get(0));
            oPartido.setEquipoVisitante(partido3.get(1));
            //getoJornada where id = numeroJornada
            //oPartido.setoJornada(oJornada);
            //listaPartidos.add(oPartido);
            //insert lista partidos
        }
        else{
            oPartido.setEquipoLocal(partido3.get(1));
            oPartido.setEquipoVisitante(partido3.get(0));
            //getoJornada where id = numeroJornada
            //oPartido.setoJornada(oJornada);
            //listaPartidos.add(oPartido);
            //insert lista partidos
        }
    }
    
    public static int randomWinner(){
        int range = (1 - 0) + 1; 
        return (int)(Math.random() * range) + 0;
    }
} 
