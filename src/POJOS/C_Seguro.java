package POJOS;
import java.io.Serializable;


// @author Miguel

public class C_Seguro implements Serializable {
    
    private int codigo;
    private String nombre,prestaciones;
    private C_Enfermo enfermo;
    
    public C_Seguro () {}
    
    public C_Seguro (int codigo, String nombre, String prestaciones) {
        
        this.codigo=codigo;
        this.nombre=nombre;
        this.prestaciones=prestaciones;
        
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

    public String getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(String prestaciones) {
        this.prestaciones = prestaciones;
    }

    public C_Enfermo getEnfermo() {
        return enfermo;
    }

    public void setEnfermo(C_Enfermo enfermo) {
        this.enfermo = enfermo;
    }

}
