/*Becoming a software engineer living in Asia*/
package bracket;

import java.util.ArrayList;


public class BRACKET {
    
    private static ArrayList<Integer> partido1;
    private static ArrayList<Integer> partido2;
    private static ArrayList<Integer> partido3;
    
    private static ArrayList<Integer> jornadaPrimera;
    private static ArrayList<Integer> jornadaNormal;

    public static void main(String[] args) {
        
        //jornadaPrimera debe ser renombrada a jornadaAnterior porque va a pasar a ser siempre n jornada -1
        jornadaPrimera = new ArrayList();
        jornadaPrimera.add(2);
        jornadaPrimera.add(3);
        jornadaPrimera.add(4);
        jornadaPrimera.add(5);
        jornadaPrimera.add(6);
        
        jornadaNormal = new ArrayList();
        
        for(int i = 0; i <= jornadaPrimera.size()-1; i++){ 
//            System.out.println((i+1));
//            System.out.println(jornadaPrimera.size());
//            System.out.println((i+1) % jornadaPrimera.size());
            jornadaNormal.add((i) % jornadaPrimera.size(), jornadaPrimera.get(i));
        }
                
        
        System.out.println(jornadaNormal.toString());
        
        
        int formulaNEquipos = (jornadaPrimera.size() + 1 -2) / 2; 
        System.out.println(formulaNEquipos);
        int idEquipoEstatico = 1;
        int ultimoEquipo = jornadaPrimera.size() - 1;
        
        partido1 = new ArrayList();
        partido1.add(idEquipoEstatico);
        partido1.add(jornadaPrimera.get(ultimoEquipo));
        System.out.println(partido1.toString());
        
        partido2 = new ArrayList();
        partido2.add(jornadaPrimera.get(formulaNEquipos - 2));
        partido2.add(jornadaPrimera.get(ultimoEquipo - 1));
        System.out.println(partido2.toString());
        
        partido3 = new ArrayList();
        partido3.add(jornadaPrimera.get(formulaNEquipos - 1));
        partido3.add(jornadaPrimera.get(ultimoEquipo - 2));
        System.out.println(partido3.toString());

    }

}
