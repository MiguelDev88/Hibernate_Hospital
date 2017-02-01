package funciones;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Menu {
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("Seleccione opción:"
                        + "\n1.Creacion de Tablas"
                        + "\n2.Inserción de filas"
                        + "\n3.Borrado de filas"
                        + "\n4.Modificaciones"
                        + "\n5.Consultas"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuAltas (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("¿Qué desea dar de alta?"
                        + "\n1.Médico"
                        + "\n2.Enfermo"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuBajas (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("¿Qué desea dar de baja?"
                        + "\n1.Médico"
                        + "\n2.Enfermo"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("¿Qué desea consultar?"
                        + "\n1.Listado de Médicos"
                        + "\n2.Listado de Enfermos"
                        + "\n3.Datos de un Paciente"
                        + "\n4.Datos de un Médico"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    } 
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
     
}
