package hospitalhibernatemiguel;
import funciones.*;
import java.io.*;


// @author Miguel
 
public class HospitalHibernateMiguel {

    
    public static void main(String[] args) throws IOException {
        
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        byte op=0;        
        
        do{
            try{
                op=Menu.menuPrincipal(leer);

                switch(op){
                    case 1:
                        CrearTablas.crearTablas();
                        break;
                    case 2:
                        Altas.altas(leer);
                        break;
                    case 3:
                        Bajas.bajas(leer);
                        break;
                    case 4:
                        Modificar.modificar(leer);
                        break;
                    case 5:
                        Consultas.consultas(leer);
                        break;
                    case 0:
                        System.exit(0);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }catch(Throwable e) {
                System.out.println("ERROR EN SESION FACTORY");
            }
        
        }while(op!=0);
        
    }
    
}
