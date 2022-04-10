package com.almacen.Almacen.Service;

import com.almacen.Almacen.Entity.Almacen;


import java.util.List;

//dependecia interface solo se definen los metodos no se hace mas nada

public interface AlmacenServices {

    //Crear almacenes en la lista
    void SaveAlmacen(List<Almacen> list);

    //Obtiene Lista de Almacenes
    List<Almacen> findAll();

    //Crear un solo Almacen
    Almacen Save(Almacen almacen);

    //eliminar Almacen
    void delete(Long id);

    //Modificar Almacen dado Id
    Almacen update(Almacen almacen, Long id);

}
