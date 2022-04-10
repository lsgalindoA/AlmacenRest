package com.almacen.Almacen.Controller;

public class AlmacenNotFound extends RuntimeException {
    //en caso de no encontrar id de Almacen
    public AlmacenNotFound(Long id) {
        super("Could not find Almacen " + id);
    }
}

