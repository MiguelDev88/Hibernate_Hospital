package hospitalhibernatemiguel;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// @author Miguel

public class CrearTablas {
    
    public static void crearTablas () {
        
        try{
            
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();
            
            sentencia.execute("CREATE DATABASE IF NOT EXISTS HOSPITAL_MIGUEL");
            sentencia.execute("USE HOSPITAL_MIGUEL");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS Seguros ("
                                    + "codigo int not null, "
                                    + "nombre varchar(20) not null, "
                                    + "prestaciones varchar(30) not null, "
                                    + "PRIMARY KEY (codigo)) "
                                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS Enfermos ("
                                    + "codigoSeguro int not null, "
                                    + "dni char(9) not null, "
                                    + "nombre varchar(20) not null, "
                                    + "patologia varchar(30) not null, "
                                    + "PRIMARY KEY (codigoSeguro), "
                                    + "FOREIGN KEY (codigoSeguro) REFERENCES Seguros(codigo) "
                                        + "ON UPDATE CASCADE "
                                        + "ON DELETE CASCADE)"
                                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS Medicos ("
                                    + "codigo int not null, "
                                    + "nombre varchar(30) not null, "
                                    + "especialidad varchar(30) not null, "
                                    + "clinica varchar(30) not null, "
                                    + "PRIMARY KEY (codigo)) "
                                    + "ENGINE INNODB;");
            
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS Medicos_Enfermos ("
                                    + "medico int not null, "
                                    + "enfermo int not null, "
                                    + "PRIMARY KEY (medico,enfermo), "
                                    + "FOREIGN KEY (medico) REFERENCES Medicos(codigo) "
                                        + "ON UPDATE CASCADE "
                                        + "ON DELETE CASCADE ,"
                                    + "FOREIGN KEY (enfermo) REFERENCES Enfermos(codigoSeguro) "
                                        + "ON UPDATE CASCADE "
                                        + "ON DELETE CASCADE)"
                                    + "ENGINE INNODB;");
            
            System.out.println(" - Base de Datos Lista -");
            
            
        }catch(SQLException e) {
            
            System.out.println(e.getMessage());
            
        }
        
    }

}
