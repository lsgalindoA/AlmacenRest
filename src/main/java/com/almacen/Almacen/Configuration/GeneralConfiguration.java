package com.almacen.Almacen.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

//clase de configruacion
@Configuration

public class GeneralConfiguration {
    //se configurar la base de datos
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testAlmacenDB");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("123");
        return dataSourceBuilder.build();
    }

}
