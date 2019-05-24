package main;
/**
 * @author Mamecorp
 * 
 */
import generadorDOM.GeneradorDOMClasificacion;
import generadorDOM.GeneradorDOMJornada;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;
import modeloDB.*;
import parserDOM.ParserDOMJornada;
import parserDOM.ParserDomClasificacion;
import vistas.*;



public class MainEsports {
    /** 
    * Zona de declaración de variables globales
    */
    private static VentanaCategoria vCategoria;
    private static VentanaAdministradores vAdmin;
    private static VentanaModUsuarios vUsuario;
  
    private static Connection con;
    
    private static Sesion oSesion;
    private static Jugador oJugador;
    
    /**
     * VARIABLES PARA LA CREACION DE LOS PARTIDOS
     */
    private static ArrayList<Equipo> listaEquipos;
    /**
     * Los ArrayList de partido almacenan los objetos de los 2 equipos enfrentados
     */
    private static ArrayList<Equipo> partido1;
    private static ArrayList<Equipo> partido2;
    private static ArrayList<Equipo> partido3;
    /**
     * Los ArrayList de jornada almacenan los objetos de equipo en una posicion determianda
     * para realizar los emparejamientos correctos.
     */
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
    private static ArrayList<Jornada> listaJornadas; //Para mostrar las jornadas en la ventana visualizacion
    private static ArrayList<Partido> listaPartidos;
    private static ArrayList<Jugador> listaJugadores;
    private static ArrayList<Presidente> listaPresidentes;
    private static Presidente oPresidente;
    private static boolean simular;
    private static LocalDate fechaActualizadoXML;
    private static ArrayList<Equipo> arrayRanking; //Aqui vamos a almacenar el ranking tras leer el xml
    private static String nombreUser;
    private static String tipoUser;
    private static ArrayList<Jornada> jornadas;
    
    

    
    
    public static void main(String[] args) throws SQLException, Exception {

        GenericoDB.conectar();
        con =  GenericoDB.getCon();
        if(con != null){           
            //crearRoundRobinEmparejamientos(true);
            ControladorVista.mostrarLogin();
        }
    }
       
    
    /**
     * Con el  método "consultarEquipos()"consultamos TODOS los equipos de nuestra BD
     * @return Retornamos un ArrayList con los equipos que hemos encontrado en nuestra BD.
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Equipo> consultarEquipos() throws Exception{

        listaEquipos = EquipoDB.consultarTodos();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }
        
        return listaEquipos;
    }
    
    /**
     * Con el  método "consultarEquipoSinPresidente()" buscamos en nuestra BD los equipos
     * que no tienen presidente.
     * @return retornamos un ArrayList con los equipos sin presidente
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList consultarEquipoSinPresidente() throws Exception{
        
        listaEquipos = EquipoDB.consultarEquipoSinPresidente();

        System.out.println(listaEquipos.size());
        return listaEquipos;
    }
    /**
     *Con el  método "consultarJornadas()" consultamos todas las jornadas 
     * @return nos retorna un ArrayList de jornadas
     * @throws SQLException controlamos las posibles excepciones de SQL
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Jornada> consultarJornadas() throws SQLException, Exception{
        oLiga = LigaDB.getObjetoLiga();
        listaJornadas = JornadaDB.consultarJornadas(oLiga); //Lo guardamos para reutilizarlo en consultar partidos dado que necesitamos los objetos jornada de cada partido.
        return listaJornadas;
    }
    /**
     * Con el  método consultarPartidosDeCadaJornada consultamos todos los partidos
     * de cada jornada.
     * @return retornamos un ArrayList de jornadas con el resultado
     * @throws Exception  Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con el método "getClasificacion()" obtenemos la clasificación de nuesta BD
     * @return retornamos el método EquipoDB.getClasificacion();
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Equipo> getClasificacion() throws Exception{
        return EquipoDB.getClasificacion();
    }
    
    public static Equipo consultarEquipoDelPresidente(String presidenteBaja) throws Exception{
        return EquipoDB.consultarEquipoDelPresidente(presidenteBaja);
    }

    /**
     * 
     * @param nombre -- Nombre del equipo a insertar(String)
     * @param presupuesto -- Presupuesto del equipo a insertar(int)
     * @param puntos -- Puntos del equipo a insertar(int)
     * @return retornamos  equipoDB.insertarEquipo(e) con el objeto  
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarEquipos(String nombre,int presupuesto,int puntos) throws Exception{
    
        Equipo e = new Equipo(nombre,presupuesto,puntos);
        EquipoDB equipoDB = new EquipoDB();
        
        return equipoDB.insertarEquipo(e);  

    }
    /**
     * Con el  método "buscarEquipo" buscamos un equipo para las opciones borrar y modificar
     * @param nombreEquipo -- Nombre del equipo que queremos borrar o modificar(String)
     * @return retornamos el equipo
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static Equipo buscarEquipo(String nombreEquipo) throws Exception{
        oEquipo = EquipoDB.buscarEquipo(nombreEquipo);
        return oEquipo;
    }
    /**
     * Con el  método "modificarEquipo()" recibimos los parametros que hemos recogido en la ventana
     * @param nombre -- Nombre del equipo a buscar(String)
     * @param presupuesto -- Presupuesto del equipo a buscar(int)
     * @param puntos -- Puntos del equipo a buscar(int)
     * @return retornamos el numero de filas afectadas en la BD, con ese numero trabajaremos para controlas si se ha ejecutado correctamente
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int modificarEquipo(String nombre,int presupuesto, int puntos) throws Exception{
       
        int update = EquipoDB.modificarEquipo(oEquipo.getIdEquipo(),nombre,presupuesto,puntos);
    
         return update;
    }
    /**
     * Con el  método "borrarEquipo()" 
     * @param nombre -- Nombre del equipo a insertar(String)
     * @param presupuesto -- Presupuesto del equipo a insertar(int)
     * @param puntos -- Puntos del equipo a insertar(int)
     * @return retornamos el método EquipoDB.borrarEquipo
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */
    public static int borrarEquipo(String nombre,int presupuesto, int puntos) throws Exception{
        oEquipo = EquipoDB.buscarEquipo(nombre);
        return EquipoDB.borrarEquipo(oEquipo.getIdEquipo(),nombre,presupuesto,puntos);
    
    }
    /**
     * Con el método "insertarAdministrador()" insertamos un nuevo usuario administrador
     * @param nombre -- Nombre del administrador a insertar(String)
     * @param password -- Password del administrador a insertar(String)
     * @return retornamos metodo
     * @throws Exception Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarAdministrador(String nombre,String password) throws Exception{
    
        oSesion = new Sesion(nombre,password);
        SesionDB sesionDB = new SesionDB();
        
        return SesionDB.insertarAdministrador(nombre,password);
    }
    /**
     * Con el método "insertarUsuario()" insertamos un nuevo usuario 
     * @param nombre -- Nombre del usuario a insertar(String)
     * @param password -- Password del usuario a insertar(String)
     * @return metodo 
     * @throws Exception Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarUsuario(String nombre,String password) throws Exception{
        oSesion = new Sesion(nombre,password);
        SesionDB sesionDB = new SesionDB();
        
        return SesionDB.insertarUsuario(nombre,password);
    }
    /**
     * Con el método "insertarPresidente" insertamos un nuevo presidente en la BD con los parametros tecleados en la ventana
     * @param nombrePresidente -- Nombre del presidente(String)
     * @param apellidoPresidente -- Apellido del presidente(String)
     * @param idEquipo --id del equipo obtenida en un comboBox(int)
     * @return devuelve el método PresidenteDB.insertarPresi con un objeto Presidente
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarPresidente(String nombrePresidente, String apellidoPresidente,String idEquipo) throws Exception {
         
       oEquipo = EquipoDB.consultarEquipoPresidente(idEquipo);
       oPresidente = new Presidente(nombrePresidente,apellidoPresidente,oEquipo);

        return PresidenteDB.insertarPresi(oPresidente);
    }
   /**
    * Con el método "borrarPresidente()" obtenemos los parametros del presidetne a borrar
     * @param nombre -- Nombre del presidente(String)
     * @param apellido -- Apellido del presidente(String)
    * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
    */  
    public static boolean borrarPresidente(String nombre,String apellido) throws Exception{
        oPresidente = PresidenteDB.consultarPresidente(nombre,apellido);

         return PresidenteDB.borrarPresi(nombre,apellido);

    }
     
     
    /**
     * Con el método "comprobarLogin" comprobamos que el usuario que intenta iniciar sesión existe
     * @param nombre -- nombre del usuario(String)
     * @param password -- password del usuario(String)
     * @return retorna el método  SesionDB.consultarUsuario
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */
    public static Sesion comprobarLogin(String nombre,String password) throws Exception{
        return SesionDB.consultarUsuario(nombre,password);
    }
    public static void cogerUser(String nombre, String tipo){
        
    nombreUser = nombre;
    tipoUser = tipo;
        System.out.println(nombreUser);
    
    }
    public static String getNombreUser() {
        System.out.println(nombreUser);
        return nombreUser;
    }

    public static String getTipoUser() {
        return tipoUser;
    }
    
    
    

    /**
     *  Con el método "mostrarJugadores" mostramos todos los jugadores
     * @return retornamos un ArrayList con los jugadores
     * @throws Exception  Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Jugador> mostrarJugadores() throws Exception{
        
       // listaJugadores = JugadorDB.consultarJugador();
        return listaJugadores;
    } 
    /**
     * Con el método "darBajaJugador" damos de baja un jugador 
     * @param nick -- Nickname del jugador, recogido en la ventana(String)
     * @return retornamos un objeto para controlar que se ha ejecutado correctamente
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */        
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
    /**
     * Con el método "consultarJugadorABorrar()" consultamos el jugador a borrar
     * @param nick -- Nickname del jugador a borrar(String)
     * @return retornamos  el método JugadorDB.consultarJugador(nick);
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */
    public static Jugador consultarJugadorABorrar(String nick) throws Exception{
       return JugadorDB.consultarJugador(nick); 
    }
    /**
     * Con el método "consultarJugadorAModificar()" buscamos el jugador a modificar
     * @param nick -- Nickname del jugador a modificar(String)
     * @return retornamos el método JugadorDB.consultarJugador(nick);
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */
    public static Jugador consultarJugadorAModificar(String nick) throws Exception{
        return JugadorDB.consultarJugador(nick);
    }
    /**
     * Con el método "buscarEquipoDelJugador()" buscamos el equipo al que pertenece un jugador
     * @param equipoIdEquipo -- id del equipo(int)
     * @return  retornamos el método EquipoDB.consultarEquipoDelJugador(equipoIdEquipo)
     * @throws SQLException controlamos las excepciones de SQL
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static Equipo buscarEquipoDelJugador(int equipoIdEquipo) throws SQLException, Exception{
        return EquipoDB.consultarEquipoDelJugador(equipoIdEquipo);
    }
    /**
     * Con el método "modificarJugador()" modificamos un jugador a partid de los parametros recibidos
     * @param nick -- Nickname nuevo del jugador(String)
     * @param sueldo -- Sueldo nuevo del jugador(int)
     * @param titularidad -- Titularidad nueva del jugador(boolean)
     * @param posicion -- Posición nueva del jugador(String)
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */
    public static boolean modificarJugador(String nick,int sueldo,boolean titularidad, String posicion, String nicknameAntiguo) throws Exception{
        
        return JugadorDB.modificarJugador(nick,sueldo,titularidad,posicion,nicknameAntiguo);
        
    }
    /**
     * Con el método "mostrarEquipos()" mostramos todos los equipos
     * @return retornamos un ArrayList con objetos de tipo Equipo
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Equipo> mostrarEquipos() throws Exception{
        
        listaEquipos = EquipoDB.consultarTodos();
        for(int i = 0; i < listaEquipos.size(); i++){
            int idEquipo = listaEquipos.get(i).getIdEquipo();
            listaJugadores = JugadorDB.consultarJugadorDelEquipo(idEquipo);
            listaPresidentes = PresidenteDB.consultarPresidentesDelEquipo(idEquipo);
            listaEquipos.get(i).setListaJugadores(listaJugadores);   
            listaEquipos.get(i).setListaPresidentes(listaPresidentes);
        }
        
        if(listaEquipos.size()>0){
        
        return listaEquipos;
        } else {
        return null;
        }
    }
     /**
     * Con el método "insertarJugadores()"
     * @param nombre -- Nombre del jugador(String)
     * @param apellido -- Apellid del jugador(String)
     * @param nickname -- Nickname del jugador(String)
     * @param posicion --Posicion del jugador(String)
     * @param sueldo -- Sueldo del jugador(int)
     * @param titularidad -- Titularidad del jugador(Boolean)
     * @param posicionEquipo --
     * @return retornamos el método JugadorDB.insertarJugadores(oJugador);
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static boolean insertarJugadores(String nombre, String apellido, String nickname, String posicion, int sueldo, boolean titularidad, int posicionEquipo) throws Exception {
        //Obtenemos la lista de equipos
        listaEquipos = EquipoDB.consultarTodos();
        //Seleccionamos el elegido por el usuario
        oEquipo = listaEquipos.get(posicionEquipo);
        //Creamos el jugador
        oJugador = new Jugador(nombre, apellido, nickname, posicion, sueldo, titularidad, oEquipo);
        return JugadorDB.insertarJugadores(oJugador);
    }
    
    public static Equipo llenarCbEquipoModJugador(String nickname) throws Exception{
        return EquipoDB.llenarCbEquipoModJugador(nickname);
    }

    public static Jugador modificarJugador(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Con el método "updateVencedorYpuntosNoSimulados()"
     * @param oPartido --
     * @param equipoVencedor --
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error 
     */
    
    public static void updateVencedorYpuntosNoSimulados(Partido oPartido, String equipoVencedor) throws Exception{
        oEquipo = EquipoDB.buscarEquipo(equipoVencedor);
        boolean updateCorrectoVencedor = PartidoDB.updateVencedorNoSimulados(oPartido, oEquipo);
        boolean updateCorrectoPuntos = EquipoDB.updatePuntosEquipo(oPartido);
        System.out.println(updateCorrectoVencedor);
        System.out.println(updateCorrectoPuntos);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Con el método crearRoundRobinEmparejamientos()
     * @param simular --
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static void crearRoundRobinEmparejamientos(boolean simular) throws Exception{
        MainEsports.simular = simular;
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
        
        //comprobamos que se ha simulado correctamente
        int nPartidos = PartidoDB.consultarCountPartidos();
        if(nPartidos == 30 && simular == true){
            ControladorVista.simulacionCorrecta();
        }
        else if (nPartidos == 30 && simular == false){
            ControladorVista.emparejamientosCorrectos();
        }
        else{
            ControladorVista.simulacionError();
        }
    }
    
    
 
    /**
     * Con el método "crearArrayNextJornada()" generamos una nueva jornada
     */
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
    
    /**
     * Con el método "crearPartidos()" 
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
        
        //Chequear si vamos a simular el partido o no.
        if(simular){
            oPartido.setEquipoVencedor(partido1.get(randomWinner()));
            insertPartidos();
            updatePuntosEquipo();
        }
        else{
            insertPartidos();
        }

        
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
        
        //Chequear si vamos a simular el partido o no.
        if(simular){
            oPartido.setEquipoVencedor(partido2.get(randomWinner()));
            insertPartidos();
            updatePuntosEquipo();
        }
        else{
            insertPartidos();
        }
        
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
        
        //Chequear si vamos a simular el partido o no.
        if(simular){
            oPartido.setEquipoVencedor(partido3.get(randomWinner()));
            insertPartidos();
            updatePuntosEquipo();
        }
        else{
            insertPartidos();
        }
    }
    
    /**
     * Con el método "insertPartidos()"  
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static void insertPartidos() throws Exception{
        oJornada.setoLiga(oLiga);
        oPartido.setoJornada(oJornada);
        //Insert partido
        if(simular){
            PartidoDB.insertarPartido(oPartido);
        }
        else{
            PartidoDB.insertarPartidoSinVencedor(oPartido);
        }

        //Cambiamos el valor del bolean EquipoEstaticoEsLocal. Si esta jornada ha sido local la siguiente será visitante o viceversa. 
        EquipoEstaticoEsLocal = !EquipoEstaticoEsLocal;
    }
    /**
     * Con el método "updatePuntosEquipo()" actualizamos los puntos de un equipo
     * @throws Exception  Exception controlamos las excepciones por si hubiese algun tipo de errors
     */
    public static void updatePuntosEquipo() throws Exception{
        EquipoDB.updatePuntosEquipo(oPartido);
    }
    /**
     * Con el método "randomWinner()" generamos un ganador
     * @return numero
     */
    public static int randomWinner(){
        int range = (1 - 0) + 1; 
        return (int)(Math.random() * range) + 0;
    }
   
 
    public static void generarCalendario() throws Exception{
    
    JornadaDB.generarCalendario();

    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    public static void verificarActualizarXMLClasificacion() throws Exception{
        
        if(JornadaDB.countJornadas() != 0){
        //Leemos el xml
        ParserDomClasificacion.run();
        //Obtenemos la fecha de ultimo actualizdo de la clasificacion desde el xml
        fechaActualizadoXML = ParserDomClasificacion.getFechaActualizado();
        //Si la ultima fecha de actualizacion es de hace mas de 7 dias lo volvemos a actualizar con una consulta a la base de datos.
        if(LocalDate.now().isAfter(fechaActualizadoXML.plusDays(7))){
            GeneradorDOMClasificacion.main(null);
            ParserDomClasificacion.run();
        }
        //Almacenamos el ranking en un array
        arrayRanking = ParserDomClasificacion.getListaEquipos(); 
        }
    }
    
    public static ArrayList<Equipo> getRanking(){
        return arrayRanking;
    }
    
    public static ArrayList<Jornada> jornadasXML() throws Exception{
        File f = new File("../Jornada.xml");
        if(JornadaDB.countJornadas() != 0){
            if(!f.exists()){
            GeneradorDOMJornada.main(null);
            } 
        }
        //Obtener los datos del xml jornadas
        ParserDOMJornada.run();
        return ParserDOMJornada.getListaJornadas();
    }

    public static String llamarProcedureVisualizarEquipos() throws SQLException, Exception{
        String listaEquipos = EquipoDB.llamarProcedure();

        return listaEquipos;  
    }   

    
}