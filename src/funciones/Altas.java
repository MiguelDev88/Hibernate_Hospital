package funciones;
import POJOS.*;
import hospitalhibernatemiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel

public class Altas {
    
    
    public static void altas (BufferedReader leer) throws IOException {
        
        byte op=1;

        while(op!=0){
            op=Menu.menuAltas(leer);
            switch(op){
                case 1:
                    altaMedico(leer);
                    break;
                case 2:
                    altaEnfermo(leer);
                    break;
            }
        }
    }
    
    public static void altaMedico (BufferedReader leer) {
        
        byte op;
        
        try{
            Session sesion=HibernateUtil.getSession();
            
            C_Medico medico=nuevoMedico(leer);
            sesion.beginTransaction();
            sesion.save(medico);
            sesion.getTransaction().commit();
            
            System.out.println("¿Desea asociar algún Enfermo a este Médico?"
                        + "\n1.Si"
                        + "\n2.No");
            op=Byte.parseByte(leer.readLine());
            
            if(op==1)
                Asociar.asociarEnfermo(medico, sesion, leer);
            
            sesion.close();
            
            System.out.println("\n - MEDICO CREADO - \n");

        }catch(Exception e){
            
            System.out.println("Error en la creación del Médico, no se han guardado los datos");
            System.out.println(e.getMessage());
        }
            
    }
    
    public static void altaEnfermo (BufferedReader leer) {
        
        byte op;
        
        try{
            Session sesion=HibernateUtil.getSession();
            
            C_Enfermo enfermo=nuevoEnfermo(leer);
            sesion.beginTransaction();
            sesion.save(enfermo);
            sesion.getTransaction().commit();

            System.out.println("¿Desea asociar algún Médico a este Enfermo?"
                        + "\n1.Si"
                        + "\n2.No");
            op=Byte.parseByte(leer.readLine());
            
            if(op==1)
                Asociar.asociarMedico(enfermo, sesion, leer); 
            
            sesion.close();
            
            System.out.println("\n - ENFERMO CREADO - \n");
            
        }catch(Exception e){
            System.out.println("Error en la creación del Enfermo, no se han guardado los datos");
            System.out.println(e.getMessage());
        }  
    }
    
    public static C_Medico nuevoMedico (BufferedReader leer) throws IOException {
        
        int codigo;
        String nombre, especialidad, clinica;
        C_Medico medico;

        System.out.println("Introducir código:");
        codigo=Integer.parseInt(leer.readLine());
        
        System.out.println("Introducir nombre");
        nombre=leer.readLine();
        
        System.out.println("Introducir especialidad");
        especialidad=leer.readLine();
        
        System.out.println("Introducir clinica");
        clinica=leer.readLine();
        
        medico=new C_Medico(codigo,nombre,especialidad,clinica);
        
        return medico;
        
    }
    
    public static C_Enfermo nuevoEnfermo (BufferedReader leer) throws IOException {
        
        String dni, nombre, patologia;
        C_Enfermo enfermo;
        C_Seguro seguro;
        
        System.out.println("Introducir DNI:");
        dni=leer.readLine();
        
        System.out.println("Introducir nombre:");
        nombre=leer.readLine();
        
        System.out.println("Introducir patología:");
        patologia=leer.readLine();
        
        seguro=nuevoSeguro(leer);
        
        enfermo=new C_Enfermo(dni,nombre,patologia);
        
        seguro.setEnfermo(enfermo);
        enfermo.setSeguro(seguro);
        
        return enfermo;
        
    }

    public static C_Seguro nuevoSeguro(BufferedReader leer) throws IOException {
        
        int codigo;
        String nombre, prestaciones;
        C_Seguro seguro;
        
        
        System.out.println("Introducir código del Seguro:");
        codigo=Integer.parseInt(leer.readLine());
        
        System.out.println("Introducir nombre del Seguro:");
        nombre=leer.readLine();
        
        System.out.println("Introducir prestaciones del seguro");
        prestaciones=leer.readLine();
        
        
        seguro=new C_Seguro(codigo,nombre,prestaciones);
        
        return seguro;

    }
}
