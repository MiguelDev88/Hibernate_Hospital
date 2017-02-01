package funciones;

import POJOS.*;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel

public class Asociar {
    
    public static void asociarEnfermo (C_Medico medico, Session sesion, BufferedReader leer) throws IOException {
        
        byte op=1;
        C_Enfermo enfermo;
        int codigo;
        
        while(op!=0){
            
            System.out.println("¿Desea asociar un enfermo nuevo o uno ya existente?"
                    + "\n1.Nuevo"
                    + "\n2.Existente"
                    + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine());
            try{
                switch(op){
                    case 1:
                        sesion.beginTransaction();
                        enfermo=Altas.nuevoEnfermo(leer);
                         
                        if(sesion.get(C_Enfermo.class,enfermo.getCodigoSeguro())==null){
                            medico.getEnfermos().add(enfermo);
                            enfermo.getMedicos().add(medico);
                            
                            System.out.println("\n - ENFERMO ASOCIADO - \n");
                        }else
                            
                            System.out.println("\n - PACIENTE YA EXISTENTE EN LA BD - \n");
                        
                        sesion.getTransaction().commit();
                        
                        break;
                    case 2:
                        Consultas.verEnfermos(sesion);
                        sesion.beginTransaction();
                        
                        System.out.println("Introducir código del Enfermo a asociar:");
                        codigo=Integer.parseInt(leer.readLine());
                        
                        enfermo=(C_Enfermo)sesion.get(C_Enfermo.class, codigo);
                        if(enfermo!=null)
                        {
                            
                            medico.getEnfermos().add(enfermo);
                            enfermo.getMedicos().add(medico);

                            System.out.println("\n - ENFERMO ASOCIADO - \n");
                        }
                        else
                            System.out.println("\n No se ha encontrado al Enfermo \n");
                        sesion.getTransaction().commit();
                        break;
                }
            }catch(Exception e) {
                System.out.println(e.getMessage());
                sesion.getTransaction().rollback();
            }
        
        }
    }
    
    public static void asociarMedico (C_Enfermo enfermo, Session sesion, BufferedReader leer) throws IOException {
        
        byte op=1;
        C_Medico medico;
        int codigo;
          
        while(op!=0){
            
            System.out.println("¿Desea asociar un médico nuevo o uno ya existente?"
                    + "\n1.Nuevo"
                    + "\n2.Existente"
                    + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine());
            try{
                switch(op){
                    case 1:
                        sesion.beginTransaction();
                        medico=Altas.nuevoMedico(leer);
                        
                        if(sesion.get(C_Medico.class,medico.getCodigo())==null){
                            medico.getEnfermos().add(enfermo);
                            enfermo.getMedicos().add(medico);
                            System.out.println("\n - MEDICO ASOCIADO - \n");
                        }else
                            
                            System.out.println("\n - MEDICO YA EXISTENTE EN LA BD - \n");
                        
                        sesion.getTransaction().commit();                        

                        break;
                    case 2:
                        Consultas.verMedicos(sesion);
                        sesion.beginTransaction();
                        System.out.println("Introducir código del Médico a asociar:");
                        codigo=Integer.parseInt(leer.readLine());
                        
                        medico=(C_Medico)sesion.get(C_Medico.class, codigo);
                        if(medico!=null)
                        {
                            medico.getEnfermos().add(enfermo);
                            enfermo.getMedicos().add(medico);

                            System.out.println("\n - MEDICO ASOCIADO - \n");
                        }
                        else
                            System.out.println("\n No se ha encontrado al Médico \n");
                        sesion.getTransaction().commit();
                        break;
                }
            
            }catch(Exception e){
                System.out.println(e.getMessage());
                sesion.getTransaction().rollback();
            }
            
        }
    }
}
