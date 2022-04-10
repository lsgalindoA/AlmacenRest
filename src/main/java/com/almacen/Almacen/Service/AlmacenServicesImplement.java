package com.almacen.Almacen.Service;

import com.almacen.Almacen.Controller.AlmacenNotFound;
import com.almacen.Almacen.Entity.Almacen;
import com.almacen.Almacen.Repository.AlmacenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import java.util.List;

//clase tipo servicio
@Service

//aqui se implementa la interface de AlmacenService
public class AlmacenServicesImplement implements AlmacenServices {

    //variable de looger para guargar los debug de la clase
    private final  Logger logger = LoggerFactory.getLogger(AlmacenServicesImplement.class);

    //clase repesotory declarada
    private AlmacenRepository almacenRepository;

    //constructor par inyectar la dependecia de repositorio de la BD
    public AlmacenServicesImplement(AlmacenRepository almacenRepository)
    {
        this.almacenRepository = almacenRepository;
    }

    //metodo sobre escrito que viene de la interface Almacenes para retornar lista de Almacen
    @Override
    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    //metodo transacional para guardar almacenes es decir si hay un error se hace un rollback
    @Transactional
    public void SaveAlmacen(List<Almacen> almacenes) {
        try{
            almacenes.stream()
                    .peek(almacen -> logger.info("Insert : "+almacen))
                    .forEach(almacen -> almacenRepository.save(almacen));
        }catch (Exception e){
            logger.error("Excepcion transaccional en Save Almacenes");
        }
    }
    //metodo transacional para guardar un solo almacen es decir si hay un error se hace un rollback
    @Transactional
    public Almacen Save(Almacen almacen) {
        try{
            almacenRepository.save(almacen);
            return almacen;
        }catch (Exception e){
            logger.error("Excepcion transaccional en Save Almacen");
            return null;
        }
    }

    //metodo sobre escrito para eliminar Almacen dado Id
    @Override
    public void delete(Long id){
        almacenRepository.delete(new Almacen(id));
    }

    //metodo transacional para Actualizar un solo almacen es decir si hay un error se hace un rollback
    @Transactional
    public Almacen update(Almacen nuevo_almacen, Long id) {
            return almacenRepository.findById(id)
                    .map(
                        almacen -> {
                                almacen.setNombre(nuevo_almacen.getNombre());
                                almacen.setFecha_inaguracion(nuevo_almacen.getFecha_inaguracion());
                                almacen.setCapacitad_clientes(nuevo_almacen.getCapacitad_clientes());
                                return almacenRepository.save(almacen);
                            }).orElseThrow(() -> new AlmacenNotFound(id));
    }

}
