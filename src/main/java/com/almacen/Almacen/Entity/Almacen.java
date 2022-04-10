package com.almacen.Almacen.Entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//clase entity (es decir puede crear tablas y manejar BD)
@Entity

//creara una tabla llamada Almacen
@Table(name="Almacen")
public class Almacen {
    //campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="Id" , nullable = false, unique = true)
    private long Id;

    @Column(name="Nombre" , length = 50)
    private String Nombre;

    @Column(name="Fecha_inaguracion")
    private LocalDate Fecha_inaguracion;

    @Column(name="Capacitad_clientes")
    private long Capacitad_clientes;

    //constructor vacio
    public  Almacen(){

    }
    //constructor con Id para actualizar
    public  Almacen(Long Id){
        this.Id=Id;
    }
    //constructor con todos los campos
    public Almacen(String nombre, LocalDate fecha_inaguracion, long capacitad_clientes) {
        Nombre = nombre;
        Fecha_inaguracion = fecha_inaguracion;
        Capacitad_clientes = capacitad_clientes;
    }
    //metodo sobre escrito convertir a String el Objecto Almacen
    @Override
    public String toString() {
        return "Almacen{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Fecha_inaguracion=" + Fecha_inaguracion +
                ", Capacitad_clientes=" + Capacitad_clientes +
                '}';
    }

    //metodo que retorna el ID
    public long getId() {
        return Id;
    }

    //metodo que modifica el ID
    public void setId(long id)
    {
        Id = id;
    }
    //metodo que Obtiene Nombre
    public String getNombre()
    {
        return Nombre;
    }
    //metodo que modifica Nombre
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    //metodo que Obtiene Fecha
    public LocalDate getFecha_inaguracion()
    {
        return Fecha_inaguracion;
    }
    //metodo que modfica Fecha
    public void setFecha_inaguracion(LocalDate fecha_inaguracion)
    {
        Fecha_inaguracion = fecha_inaguracion;
    }
    //metodo que obtiene Capacidad_clientes
    public long getCapacitad_clientes()
    {
        return Capacitad_clientes;
    }
    //metodo que modifica Capacidad_clientes
    public void setCapacitad_clientes(long capacitad_clientes)
    {
        Capacitad_clientes = capacitad_clientes;
    }
}
