package com.almacen.Almacen.CaseUseAlmacen;

import com.almacen.Almacen.Entity.Almacen;
import com.almacen.Almacen.Service.AlmacenServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

//clase es un componente
@Component
public class UpdateAlmacen {
    //declarar dependencia
    private AlmacenServices almacenServices;

    //constructor para inyectar dependencia
    public UpdateAlmacen(AlmacenServices almacenServices) {
        this.almacenServices = almacenServices;
    }
    //metodo que actualiza el almacen
    public Almacen update(Almacen almacen, Long id) {
        return almacenServices.update(almacen,id);
    }
}
