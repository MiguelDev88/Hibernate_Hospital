package funciones;
import POJOS.C_Enfermo;
import hospitalhibernatemiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel

public class Modificar {
    
    
    public static void modificar (BufferedReader leer) throws IOException {
        
        String dni;
        C_Enfermo enfermo;
        
        Session sesion=HibernateUtil.getSession();
        
        try{
            sesion.beginTransaction();
            System.out.println("Introducir dni del Paciente a Modificar:");
            dni=leer.readLine();

            enfermo=(C_Enfermo)sesion.createQuery("FROM C_Enfermo e WHERE e.dni='"+dni+"'").uniqueResult();

            if (enfermo!=null)
            {
                modificarEnfermo(enfermo,sesion,leer);

            }else
                    System.out.println("\n No se ha encontrado al Enfermo \n");

            sesion.getTransaction().commit();
            sesion.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            
        }
 
    }
    
    public static void modificarEnfermo (C_Enfermo enfermo, Session sesion, BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea modificar?"
                + "\n1.Seguro del Paciente"
                + "\n2.Añadir Médicos");
        op=Byte.parseByte(leer.readLine());
        
        switch(op) {
            case 1:
                modificarSeguro(enfermo,leer);
            break;
            case 2:
                Asociar.asociarMedico(enfermo, sesion, leer);
                break;
        }
    }
    
    public static void modificarSeguro (C_Enfermo enfermo, BufferedReader leer) throws IOException {
        
        String compañia, prestaciones;
        
        System.out.println("Introducir nueva companía");
        compañia=leer.readLine();
        enfermo.getSeguro().setNombre(compañia);
        
        System.out.println("Introducir nuevas prestaciones");
        prestaciones=leer.readLine();
        enfermo.getSeguro().setPrestaciones(prestaciones);
        
        System.out.println("\n - Seguro modificado \n -");
        
        
    }
}
