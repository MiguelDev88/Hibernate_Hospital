package funciones;
import POJOS.C_Enfermo;
import POJOS.C_Medico;
import hospitalhibernatemiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel

public class Bajas {
    
    public static void bajas (BufferedReader leer) throws IOException {
        
        byte op=1;

        while(op!=0){
            op=Menu.menuBajas(leer);
            switch(op){
                case 1:
                    bajaMedico(leer);
                    break;
                case 2:
                    bajaEnfermo(leer);
                    break;
            }
        }  
    }
    
    public static void bajaMedico (BufferedReader leer) throws IOException {
        
        
        Session sesion;
        C_Medico medico;
        int codigo;
        
        try{
            sesion=HibernateUtil.getSession();
            Consultas.verMedicos(sesion);
            System.out.println("Introduzca Código del Médico a eliminar:");
            codigo=Integer.parseInt(leer.readLine());

            medico=(C_Medico)sesion.get(C_Medico.class, codigo);

            if(medico !=null)
            {
                if(Menu.menuConfirmar(leer)==1){
                    sesion.beginTransaction();
                    sesion.delete(medico);
                    sesion.getTransaction().commit();
                }
            }else
                System.out.println("\n No se ha encontrado al Médico \n");
            
            sesion.close();
            
        }catch(Exception e){
            
            System.out.println("Error al borrar");
        }
        
    }
    
    public static void bajaEnfermo (BufferedReader leer) throws IOException {
        
        
        Session sesion;
        C_Enfermo enfermo;
        int codigo;
        
        try{
            sesion=HibernateUtil.getSession();
            Consultas.verEnfermos(sesion);
            System.out.println("Introduzca Código del Enfermo a eliminar:");
            codigo=Integer.parseInt(leer.readLine());

            enfermo=(C_Enfermo)sesion.get(C_Enfermo.class, codigo);

            if(enfermo!=null)
            {
                if(Menu.menuConfirmar(leer)==1){
                    sesion.beginTransaction();
                    sesion.delete(enfermo);
                    sesion.getTransaction().commit();
                }
            }else
                System.out.println("\n No se ha encontrado al Enfermo \n");
            
            sesion.close();
            
        }catch(Exception e){
            
            System.out.println("Error al borrar");
        }
        
    }
}
