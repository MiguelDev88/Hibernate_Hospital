package funciones;

import POJOS.C_Enfermo;
import POJOS.C_Medico;
import hospitalhibernatemiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;


// @author Miguel

public class Consultas {
    
    public static void consultas (BufferedReader leer) throws IOException {
        
        Session sesion=HibernateUtil.getSession();
        byte op=1;
        
        try{

            while(op!=0)
            {
                op=Menu.menuConsultas(leer);
                switch (op){
                    case 1:
                        verMedicos(sesion);
                        break;
                    case 2:
                        verEnfermos(sesion);
                        break;
                    case 3:
                        consultarEnfermo(sesion, leer);
                        break;
                    case 4:
                        consultarMedico(sesion, leer);
                        break;
                }

            }
            sesion.close();
            
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void verMedicos (Session sesion) throws IOException {
        
        C_Medico medico;
        
        try{
            List<C_Medico> listaMedicos = sesion.createCriteria(C_Medico.class).list();
            Iterator medicos=listaMedicos.iterator();
            
            System.out.println("-------------------------------------------------");
            System.out.println("| CODIGO   |   NOMBRE   |ESPECIALIDAD| CLINICA  ");
            
            while(medicos.hasNext())
            {
                medico=(C_Medico)medicos.next();
                System.out.printf("|  %5s   |%10s  | %10s | %10s  %n",medico.getCodigo(),medico.getNombre(),medico.getEspecialidad(),medico.getClinica());
            }
            
            System.out.println("-------------------------------------------------");                   
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void verEnfermos (Session sesion) throws IOException {
        
        C_Enfermo enfermo;
        
        try{
            List<C_Enfermo> listaEnfermos = sesion.createCriteria(C_Enfermo.class).list();
            Iterator enfermos=listaEnfermos.iterator();
            
            System.out.println("-------------------------------------------------");
            System.out.println("|    DNI    |   NOMBRE   | PATOLOGIA |   SEGURO  ");
            
            while(enfermos.hasNext())
            {
                enfermo=(C_Enfermo)enfermos.next();
                System.out.printf("|  %5s    |%10s  |%10s | %10s  %n",enfermo.getDni(),enfermo.getNombre(),enfermo.getPatologia(),enfermo.getSeguro().getNombre());
            }
            
            System.out.println("-------------------------------------------------");                   
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public static void consultarEnfermo (Session sesion, BufferedReader leer) throws IOException {
        
        
        String dni;
        C_Enfermo enfermo;
        
        System.out.println("DNI del paciente a buscar:");
        dni=leer.readLine();
        
        try{
            enfermo=(C_Enfermo)sesion.createQuery("FROM POJOS.C_Enfermo e WHERE e.dni='"+dni+"'").uniqueResult();

            if(enfermo!=null)
            {
                System.out.println("DATOS DEL PACIENTE: "+enfermo.getNombre());
                    
                System.out.println("------------------------------------------------------------------------");
                System.out.println("|    DNI   |   NOMBRE   | COD_SEGURO | NOMBRE_SEGURO  |   PRESTACIONES   |");
    
                System.out.printf("|  %5s   |%10s  | %10s |   %10s   | %10s  %n",enfermo.getDni(),enfermo.getNombre(),
                        enfermo.getSeguro().getCodigo(),enfermo.getSeguro().getNombre(),enfermo.getSeguro().getPrestaciones());

                System.out.println("------------------------------------------------------------------------");
            }else
                System.out.println("\n No se ha encontrado al Enfermo \n");

         
            
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }
    
    public static void consultarMedico (Session sesion, BufferedReader leer) throws IOException {
        
        
        String nombre;
        C_Medico medico;
        
        System.out.println("Nombre del Médico a buscar:");
        nombre=leer.readLine();
        
        try{
            List listaMedicos=sesion.createQuery("FROM POJOS.C_Medico m WHERE m.nombre='"+nombre+"'").list();
            
            if(listaMedicos.size()>0){
                
                Iterator medicos=listaMedicos.iterator();

                while(medicos.hasNext())
                {
                    medico=(C_Medico)medicos.next();
                    verEnfermosMedico(medico);
                }
            }else
                System.out.println("\n No se han encontrado médicos con ese nombre \n");
         
            
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }
    
    public static void verEnfermosMedico (C_Medico medico) throws IOException {
        
        Iterator enfermos=medico.getEnfermos().iterator();
        System.out.println("ENFERMOS DEL DOCTOR:   "+medico.getNombre());
        System.out.println("------------------------------------------------");
        System.out.println("|    DNI    |   NOMBRE   | PATOLOGIA | SEGURO  ");
            
        while(enfermos.hasNext())
        {
            C_Enfermo enfermo=(C_Enfermo)enfermos.next();
            System.out.printf("|  %5s   |%10s  | %10s | %10s  %n",enfermo.getDni()
                    ,enfermo.getNombre(),enfermo.getPatologia(),enfermo.getSeguro().getNombre());
        }

        System.out.println("------------------------------------------------");
        
    }  
}
