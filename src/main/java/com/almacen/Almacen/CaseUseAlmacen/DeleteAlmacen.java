package com.almacen.Almacen.CaseUseAlmacen;

import com.almacen.Almacen.Service.AlmacenServices;
import org.springframework.stereotype.Component;

@Component
public class DeleteAlmacen {
    //declarar dependencia o clase interface
    private AlmacenServices almacenServices;

    //constructor para inyectar dependencia
    public DeleteAlmacen(AlmacenServices almacenServices) {
        this.almacenServices = almacenServices;
    }

    //caso de uso Eliminar Almacen
    public void remove(Long id) {
        almacenServices.delete(id);
    }
}
