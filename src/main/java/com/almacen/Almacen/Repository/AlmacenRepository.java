package com.almacen.Almacen.Repository;

import com.almacen.Almacen.Entity.Almacen;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//clase repository que se comunica con la BD para obtener informacion
@Repository

//clase interface donde los metodos en verdad se hacen en JpaRepository ya que se hereda de esta clase
public interface AlmacenRepository extends JpaRepository<Almacen,Long> {

    //Obtiene lista de almacenes con JDA
    @Query("select a from Almacen a")
    List<Almacen> findAll();

    //Obtiene lista de almacenes con JDA filtrado por el nombre
    @Query("select a from Almacen a where a.Nombre like ?1%")
    List<Almacen> findByAndSort(String name, Sort sort);

    //Obtiene lista de almacenes con JDA filtrado con ID
    @Query("select a from Almacen a where a.Id=?1")
    List<Almacen> findAllById(long Id);

    //Obtiene lista de almacenes con JDA entre fechas de inaguracion
    @Query("select a from Almacen a where a.Fecha_inaguracion  between  ?1 and ?2 ")
    List<Almacen> findByDateBetween(LocalDate begin, LocalDate end);

    //Obtiene Almacen con JDA dado ID
    @Query("select  distinct a from Almacen a where a.Id=?1")
    Optional<Almacen> findById(Long id);


}
