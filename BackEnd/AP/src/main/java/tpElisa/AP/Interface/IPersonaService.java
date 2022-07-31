/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpElisa.AP.Interface;

import java.util.List;
import tpElisa.AP.Entity.Persona;


public interface IPersonaService {
    public List<Persona> getPersona();
    public void savePersona (Persona persona);
    public void deletePersona (Long id);
    public Persona findPersona (Long id);
        
        
}
