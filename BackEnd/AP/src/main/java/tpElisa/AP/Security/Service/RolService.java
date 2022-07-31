/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpElisa.AP.Security.Service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpElisa.AP.Security.Entity.Rol;
import tpElisa.AP.Security.Enums.RolNombre;
import tpElisa.AP.Security.Repository.iRolRepository;

@Service
@Transactional

public class RolService {
    @Autowired
    iRolRepository  irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
