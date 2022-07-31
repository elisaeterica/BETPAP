/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpElisa.AP.Controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpElisa.AP.DTO.dtoEducacion;
import tpElisa.AP.Entity.Educacion;
import tpElisa.AP.Security.Controller.Mensaje;
import tpElisa.AP.Service.Seducacion;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins ="http://localhost:4200")

public class CEducacion {

@Autowired
Seducacion sEducacion;
        

@GetMapping("/lista")
public ResponseEntity<List <Educacion>> list(){
    List<Educacion> list = sEducacion.list();
    return new ResponseEntity(list, HttpStatus.OK);
}


@GetMapping("/datail/{id}")
public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
if(!sEducacion.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe"), HttpStatus.BAD_REQUEST);
    
}
Educacion educacion = sEducacion.getOne(id).get();
return new ResponseEntity(educacion, HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sEducacion.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    }
    sEducacion.delete(id);
    return new ResponseEntity(new Mensaje("Eliminado con éxito"), HttpStatus.OK);
}
        
@PostMapping("/create")

public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
    if(StringUtils.isBlank(dtoeducacion.getNombreE())){
        return new ResponseEntity(new Mensaje("Debe completar este campo"), HttpStatus.BAD_REQUEST);
    }
    if(sEducacion.existsByNombreE(dtoeducacion.getNombreE())){
        return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
    }
    Educacion educacion = new Educacion(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE());
    sEducacion.save(educacion);
    return new ResponseEntity(new Mensaje ("Cargado con éxito"), HttpStatus.OK);
}

@PutMapping ("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
    if(!sEducacion.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    }
    if(sEducacion.existsByNombreE(dtoeducacion.getNombreE())&& sEducacion.getByNombreE(dtoeducacion.getNombreE()).get().getId()!=id ){
        return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
    }
    if(StringUtils.isBlank(dtoeducacion.getNombreE())){
        return new ResponseEntity(new Mensaje("Debe completar este campo"), HttpStatus.BAD_REQUEST);
    }
    Educacion educacion = sEducacion.getOne(id).get();
    educacion.setNombreE(dtoeducacion.getNombreE());
    educacion.setDescripcionE(dtoeducacion.getDescripcionE());
    sEducacion.save(educacion);
    
    return new ResponseEntity(new Mensaje("Editado con éxito"), HttpStatus.OK);
            
            }
    
}
