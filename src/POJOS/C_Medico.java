package POJOS;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


// @author Miguel

public class C_Medico implements Serializable {
    
    private int codigo;
    private String nombre, especialidad, clinica;
    private Set<C_Enfermo> enfermos;
    
    public C_Medico () {}
    
    public C_Medico (int codigo, String nombre, String especialidad, String clinica) {
        
        this.codigo=codigo;
        this.nombre=nombre;
        this.especialidad=especialidad;
        this.clinica=clinica;
        this.enfermos=new HashSet<>();
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public Set<C_Enfermo> getEnfermos() {
        return enfermos;
    }

    public void setEnfermos(Set<C_Enfermo> enfermos) {
        this.enfermos = enfermos;
    }

}
