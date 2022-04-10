package com.almacen.Almacen.CaseUseAlmacen;

import com.almacen.Almacen.Entity.Almacen;
import com.almacen.Almacen.Service.AlmacenServices;
import org.springframework.stereotype.Component;

@Component
public class CreateAlmacen {
    //declarar dependencia o clase interface
    private AlmacenServices almacenServices;

    //constructor para inyectar dependencia
    public CreateAlmacen(AlmacenServices almacenServices) {
        this.almacenServices = almacenServices;
    }
    //caso de uso Crear Almacen
    public Almacen Save(Almacen almacen){
        return almacenServices.Save(almacen);
    }
}
