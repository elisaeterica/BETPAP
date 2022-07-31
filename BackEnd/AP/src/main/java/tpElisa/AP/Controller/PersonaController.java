/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpElisa.AP.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tpElisa.AP.Entity.Persona;
import tpElisa.AP.Interface.IPersonaService;

@RestController

public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    @GetMapping("personas/traer")
       
    
    public List<Persona> getPerson(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
    ipersonaService.savePersona (persona);
    return "Usuario creado con éxito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/(id)")
    public String deletePersona(@PathVariable Long id){
    ipersonaService.deletePersona(id);
    return "Usuario eliminado con éxito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/(id)")
    public Persona editPersona(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("fn") String nuevoFn,
            @RequestParam("domicilio") String nuevoDomicilio,
            @RequestParam("correo") String nuevoCorreo,
            @RequestParam("telefono") String nuevoTelefono,
            @RequestParam("img") String nuevoImg,
            @RequestParam("acerca") String nuevoAcerca) {
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre (nuevoNombre);
        persona.setApellido (nuevoApellido);
        persona.setFn (nuevoFn);
        persona.setDomicilio (nuevoDomicilio);
        persona.setCorreo (nuevoCorreo);
        persona.setTelefono (nuevoTelefono);  
        persona.setImg (nuevoImg);
        persona.setAcerca (nuevoAcerca);
        
        ipersonaService.savePersona(persona);
                
        return persona;
    }

    
}
