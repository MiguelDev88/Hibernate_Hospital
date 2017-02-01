package POJOS;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


// @author Miguel

public class C_Enfermo implements Serializable{
    
    private int codigoSeguro;
    private String dni,nombre,patologia;
    private Set<C_Medico> medicos;
    private C_Seguro seguro;

    public C_Enfermo () {}
    
    public C_Enfermo (String dni, String nombre, String patologia) {
        
        this.dni=dni;
        this.nombre=nombre;
        this.patologia=patologia;
        this.medicos=new HashSet<>();
        
    }


    public int getCodigoSeguro() {
        return codigoSeguro;
    }

    public void setCodigoSeguro(int codigoSeguro) {
        this.codigoSeguro = codigoSeguro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public Set<C_Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(Set<C_Medico> medicos) {
        this.medicos = medicos;
    }

    public C_Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(C_Seguro seguro) {
        this.seguro = seguro;
    }
    
    
    
}
