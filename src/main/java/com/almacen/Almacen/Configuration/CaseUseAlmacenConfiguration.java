package com.almacen.Almacen.Configuration;

import com.almacen.Almacen.CaseUseAlmacen.GetAlmacenes;
import com.almacen.Almacen.CaseUseAlmacen.GetAlmacenesImplement;
import com.almacen.Almacen.Service.AlmacenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//clase de configuracion de bean
@Configuration

public class CaseUseAlmacenConfiguration {
    //crea un bean de tipo Almacenes services
    @Bean
    public GetAlmacenes getAlmacenes(AlmacenServices almacenServices){
        return new GetAlmacenesImplement(almacenServices);
    }

}
