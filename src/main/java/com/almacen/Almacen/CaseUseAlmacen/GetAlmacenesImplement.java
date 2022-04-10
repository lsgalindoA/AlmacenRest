package com.almacen.Almacen.CaseUseAlmacen;

import com.almacen.Almacen.Entity.Almacen;
import com.almacen.Almacen.Service.AlmacenServices;

import java.util.List;

public class GetAlmacenesImplement implements GetAlmacenes {
    //declarar dependecia
    private AlmacenServices almacenServices;

    //constructor para inyectar dependencia
    public GetAlmacenesImplement(AlmacenServices almacenServices) {
        this.almacenServices = almacenServices;
    }

    //metodo sobre escrito que viene de la interface y este si obtiene de service los almacenes
    @Override
    public List<Almacen> getAll() {
        return this.almacenServices.findAll();
    }
}
