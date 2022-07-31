
package tpElisa.AP.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String nombre;
     @NotNull
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String apellido;
     @NotNull
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String telefono;
     @NotNull
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String direccion;
     @NotNull
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String correo;
     @NotNull
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String fn;
  
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String acerca;
    @NotNull
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")
    
    private String img;
   
    @Size (min = 1, max = 50, message = "debe completar este campo con max 50 car")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDomicilio(String nuevoDomicilio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
