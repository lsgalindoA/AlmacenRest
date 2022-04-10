package com.almacen.Almacen.Controller;

import com.almacen.Almacen.CaseUseAlmacen.CreateAlmacen;
import com.almacen.Almacen.CaseUseAlmacen.DeleteAlmacen;
import com.almacen.Almacen.CaseUseAlmacen.GetAlmacenes;
import com.almacen.Almacen.CaseUseAlmacen.UpdateAlmacen;
import com.almacen.Almacen.Entity.Almacen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//clase controladora y aqui se van a consumir los servicios restful API
@RestController
//ruta url donde se consumira los servicios API
@RequestMapping("/api/almacen")

class AlmacenRestController {

    //variable para grabar el log
    private final Logger logger = LoggerFactory.getLogger(AlmacenRestController.class);

    //se declarar las dependencias de casos de usos de las Apis
    private GetAlmacenes getAlmacenes;
    private CreateAlmacen createAlmacen;
    private DeleteAlmacen deleteAlmacen;
    private UpdateAlmacen updateAlmacen;

    //constructor que inyecta las dependencias de los casos de usos
    public AlmacenRestController(GetAlmacenes getAlmacenes, CreateAlmacen createAlmacen, DeleteAlmacen deleteAlmacen, UpdateAlmacen updateAlmacen) {
        this.getAlmacenes = getAlmacenes;
        this.createAlmacen=createAlmacen;
        this.deleteAlmacen=deleteAlmacen;
        this.updateAlmacen=updateAlmacen;
    }
    //metodo con get que obtiene la lista de almacenes
    @RequestMapping(value = "/",method = RequestMethod.GET)
    List<Almacen> get(){
        return getAlmacenes.getAll();
    }

    //metodo post para crear almacenes si el resultado HttpStatus es 201 entonces se creo registro en la BD
    @PostMapping("/")
    ResponseEntity<Almacen> CreateAlmacen(@RequestBody  Almacen almacen){
        try{
            return new ResponseEntity<>(createAlmacen.Save(almacen), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Error al Crear Almacen");
            return null;
        }
    }

    //metodo Delete para eliminar un almacen si el resultado HttpStatus es 204 entonces se elimino registro en la BD
    @DeleteMapping("/{Id}")
    ResponseEntity DeleteAlmacen(@PathVariable Long Id){
        deleteAlmacen.remove(Id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //metodo Put para Actualizar almacen si el resultado HttpStatus es 200 entonces se actualizo registro en la BD
    @PutMapping("/{Id}")
    ResponseEntity<Almacen> UpdateAlmacen(@RequestBody Almacen almacen  , Long Id){
        return new ResponseEntity<> (updateAlmacen.update(almacen,Id),HttpStatus.OK);
    }

}
