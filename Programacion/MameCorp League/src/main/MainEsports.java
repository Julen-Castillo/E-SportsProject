package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    private static Equipo oEquipo;
    private static ArrayList<Jornada> listaJornadas; //Para mostrar las jornadas en la ventan visualizacion
    private static ArrayList<Partido> listaPartidos;
    private static ArrayList<Jugador> listaJugadores;
    private static Presidente oPresidente;

    
    
    public static void main(String[] args) throws SQLException, Exception {
    
        //La linea de abajo está comentada porque todavia no está implementado el login
        // ControladorVista.mostrarVentanaVisualizarLiga();
        GenericoDB.conectar();
        con =  GenericoDB.getCon();
        if(con != null){           
            //crearRoundRobinEmparejamientos();
            ControladorVista.mostrarLogin();
        }
    }
       
    
    
    public static void consultarEquipos() throws Exception{

        listaEquipos = EquipoDB.consultarTodos();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }   
    }
    
    public static ArrayList consultarEquipoSinPresidente() throws Exception{
        
        listaEquipos = EquipoDB.consultarEquipoSinPresidente();

        System.out.println(listaEquipos.size());
        return listaEquipos;
    }
    
    public static ArrayList<Jornada> consultarJornadas() throws SQLException, Exception{
        oLiga = LigaDB.getObjetoLiga();
        listaJornadas = JornadaDB.consultarJornadas(oLiga); //Lo guardamos para reutilizarlo en consultar partidos dado que necesitamos los objetos jornada de cada partido.
        return listaJornadas;
    }
    
    public static ArrayList<Jornada> consultarPartidosDeCadaJornada() throws Exception{
        listaEquipos = EquipoDB.consultarTodos(); //Lo guardamos para reutilizaro en consultar partidos dado que necesitamos los objetos equipo de cada partido.
        listaPartidos = PartidoDB.consultarPartidos(listaJornadas, listaEquipos);
        int nPartido = 0; //llevamos el count de partidos asignados para a cada jornada asignarle los partidos 1, 2, 3 // 4, 5, 6.... en lugar de 1,2,3 // 1,2,3......
        //Vamos a guardar la lista de partidos en cada objeto jornada.
        for(int i = 0; i < listaJornadas.size(); i++){
            for(int x = 0; x < 3; x++){ //3, dado que hay 3 partidos por jornada                 
                listaJornadas.get(i).getListaPartidos().add(listaPartidos.get(nPartido));
                nPartido++;
            }
        }
        return listaJornadas;
    }
    
    public static ArrayList<Equipo> getClasificacion() throws Exception{
        return EquipoDB.getClasificacion();
    }


    public static int insertarEquipos(String nombre,int presupuesto,int puntos) throws Exception{
    
        Equipo e = new Equipo(nombre,presupuesto,puntos);
        EquipoDB equipoDB = new EquipoDB();
        
        return equipoDB.insertarEquipo(e);  

    }
    
    public static int insertarAdministrador(String nombre,String password) throws Exception{
    
        oSesion = new Sesion(nombre,password);
        SesionDB sesionDB = new SesionDB();
        
        return SesionDB.insertarAdministrador(nombre,password);
    }
    public static int insertarUsuario(String nombre,String password) throws Exception{
    
        oSesion = new Sesion(nombre,password);
        SesionDB sesionDB = new SesionDB();
        
        return SesionDB.insertarUsuario(nombre,password);
    }
    
     public static int insertarPresidente(String nombrePresidente, String apellidoPresidente,String idEquipo) throws Exception {
         
       oEquipo = EquipoDB.consultarEquipoPresidente(idEquipo);
       oPresidente = new Presidente(nombrePresidente,apellidoPresidente,oEquipo);
      
        
        return PresidenteDB.insertarPresi(oPresidente);
  
    }
     
     public static void borrarPresidente(String nombre,String apellido) throws Exception{
         oPresidente = PresidenteDB.consultarPresidente(nombre,apellido);
         if (oPresidente == null) {
            
            
         }
         else {
          int delete = PresidenteDB.borrarPresi(nombre,apellido);
             
          if (delete > 0){
              JOptionPane.showMessageDialog(null, delete + " filas eliminadas");
          }
             
         }
     }
     
     

    public static Sesion comprobarLogin(String nombre,String password) throws Exception{
        return SesionDB.consultarUsuario(nombre,password);
    }
    public static ArrayList<Jugador> mostrarJugadores() throws Exception{
        
       // listaJugadores = JugadorDB.consultarJugador();
        return listaJugadores;
    } 
            
    public static Jugador darBajaJugador(String nick) throws Exception{
       oJugador = JugadorDB.consultarJugador(nick);
       if (oJugador == null){
           
           return null;
       }
       else {
           String jugador = oJugador.getNickname();
           JugadorDB.darBajaJugador(jugador);
       }
       
       return oJugador;    
    }
    public static Jugador modificarJugador(String nick,int sueldo,boolean titularidad, String posicion) throws Exception{
        
        oJugador = JugadorDB.modificarJugador(nick,sueldo,titularidad,posicion);
        if (oJugador == null){
        JOptionPane.showMessageDialog(null, "Este jugador no exisate");
            return null;
        }
        return null;
    }
    public static ArrayList<Equipo> mostrarEquipos() throws Exception{
        
        listaEquipos = EquipoDB.consultarTodos();
        for(int i = 0; i < listaEquipos.size(); i++){
            int idEquipo = listaEquipos.get(i).getIdEquipo();
            listaJugadores = JugadorDB.consultarJugadorDelEquipo(idEquipo);
            listaEquipos.get(i).setListaJugadores(listaJugadores);            
        }
        
        if(listaEquipos.size()>0){
        
        return listaEquipos;
        } else {
        return null;
    }}
    
    
    public static void crearRoundRobinEmparejamientos() throws Exception{
        //Obtenemos el objeto de la liga para meterlo dentro del objeto jornada posteriormente
        oLiga = LigaDB.getObjetoLiga();
        
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
            System.out.println("FIN DE LA JORNADA NUMERO: " + numeroJornada);
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
        System.out.println("Array Jornada Anterior");
        for(int i = 0; i < listaEquipos.size(); i++){
            System.out.println(jornadaAnterior.get(i).getIdEquipo());
        }
        //Array de la nueva jornada
        System.out.println("Array Jornada Actual");
        for(int i = 0; i < listaEquipos.size(); i++){
            System.out.println(jornadaActual.get(i).getIdEquipo());
        }     
    }
    

    public static void crearPartidos() throws Exception{
        System.out.println("PARTIDOS");
        //Obtenemos el objeto de la jornada actual para meterlo dentro del objeto partido
        oJornada = JornadaDB.getObjetoJornada(numeroJornada);
        
        //PARTIDO 1
        partido1 = new ArrayList();
        partido1.add(oEquipoEstatico); //primer equipo de la lista
        partido1.add(jornadaAnterior.get(posicionUltimoEquipoArray)); //lo emparejamos con el ultimo equipo del array
        System.out.println(partido1.get(0).getNombre() + " VS " + partido1.get(1).getNombre()); // 1 vs 6

        
        //SET DATOS PARTIDO 1
        oPartido = new Partido();
        
        //Para el primer partido de cada jornada nos es irrelevante saber si corresponde a la ida o la vuelta.
        if(EquipoEstaticoEsLocal){
            oPartido.setEquipoLocal(partido1.get(0));
            oPartido.setEquipoVisitante(partido1.get(1));
        }
        else{
            oPartido.setEquipoLocal(partido1.get(1));
            oPartido.setEquipoVisitante(partido1.get(0));   
        }
        oPartido.setEquipoVencedor(partido1.get(randomWinner()));            
        insertPartidos();
        updatePuntosEquipo();

        
        //PARTIDO 2
        partido2 = new ArrayList();
        partido2.add(jornadaAnterior.get(0)); //segundo equipo de la lista (es el primero del array)
        partido2.add(jornadaAnterior.get(posicionUltimoEquipoArray - 1)); //lo emparejamos contra el penultimo 
        System.out.println(partido2.get(0).getNombre() + " VS " + partido2.get(1).getNombre()); // 2 vs 5

        
        //SET DATOS PARTIDO 2
        oPartido = new Partido();
        
        if(primeraVuelta){
            oPartido.setEquipoLocal(partido2.get(1));
            oPartido.setEquipoVisitante(partido2.get(0));      
        }
        else{
            oPartido.setEquipoLocal(partido2.get(0));
            oPartido.setEquipoVisitante(partido2.get(1));
        }
        oPartido.setEquipoVencedor(partido2.get(randomWinner()));            
        insertPartidos();
        updatePuntosEquipo();
        
        //PARTIDO 3
        partido3 = new ArrayList();
        partido3.add(jornadaAnterior.get(1)); //tercer equipo de la lista (es el segundo del array)
        partido3.add(jornadaAnterior.get(posicionUltimoEquipoArray - 2)); //lo emparejamos contra el antepenultimo
        System.out.println(partido3.get(0).getNombre() + " VS " + partido3.get(1).getNombre()); // 3 vs 4

        
        //SET DATOS PARTIDO 3
        oPartido = new Partido();
        
        if(primeraVuelta){
            oPartido.setEquipoLocal(partido3.get(0));
            oPartido.setEquipoVisitante(partido3.get(1));
        }
        else{
            oPartido.setEquipoLocal(partido3.get(1));
            oPartido.setEquipoVisitante(partido3.get(0));
        }
        oPartido.setEquipoVencedor(partido1.get(randomWinner()));            
        insertPartidos();
        updatePuntosEquipo();
    }
    
    
    public static void insertPartidos() throws Exception{
        oJornada.setoLiga(oLiga);
        oPartido.setoJornada(oJornada);
        //Insert partido
        PartidoDB.insertarPartido(oPartido);

        //Cambiamos el valor del bolean EquipoEstaticoEsLocal. Si esta jornada ha sido local la siguiente será visitante o viceversa. 
        EquipoEstaticoEsLocal = !EquipoEstaticoEsLocal;
    }
    
    public static void updatePuntosEquipo() throws Exception{
        EquipoDB.updatePuntosEquipo(oPartido);
    }
    
    public static int randomWinner(){
        int range = (1 - 0) + 1; 
        return (int)(Math.random() * range) + 0;
    }

    public static boolean insertarJugadores(String nombre, String apellido, String nickname, String posicion, int sueldo, boolean titularidad, int posicionEquipo) throws Exception {
        //Obtenemos la lista de equipos
        listaEquipos = EquipoDB.consultarTodos();
        //Seleccionamos el elegido por el usuario
        oEquipo = listaEquipos.get(posicionEquipo);
        //Creamos el jugador
        oJugador = new Jugador(nombre, apellido, nickname, posicion, sueldo, titularidad, oEquipo);
        return JugadorDB.insertarJugadores(oJugador);
    }
} 
