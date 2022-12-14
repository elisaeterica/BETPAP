/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpElisa.AP.Security.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tpElisa.AP.Security.Entity.Usuario;

@Repository

public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existByNombreUsuario(String nombreUsuario);
    boolean existByEmail(String email);
}
