package com.almacen.Almacen;

import com.almacen.Almacen.Entity.Almacen;
import com.almacen.Almacen.Repository.AlmacenRepository;
import com.almacen.Almacen.Service.AlmacenServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class AlmacenApplication implements CommandLineRunner {
	private final Log logger = LogFactory.getLog(this.getClass());
	private AlmacenServices almacenServices;

	public AlmacenApplication(AlmacenServices almacenServices) {
		this.almacenServices = almacenServices;
	}

	//probando y guardando dos Almacenes por consola (mas estos no son los microservicos api - estos se encuentran en AlmacenRestContoller)
	private void saveAlmacenInDB() {
		Almacen almacen1 = new Almacen("Almacen D1", LocalDate.of(2021, 03, 15),200);
		Almacen almacen2 = new Almacen("Almacen D2", LocalDate.of(2021, 03, 15),300);

		List<Almacen> list = Arrays.asList(almacen1, almacen2);
		this.almacenServices.SaveAlmacen(list);
		//this.almacenRepository.saveAll(list);
	}

	//probando por consola la lista de almacenes (mas estos no son los microservicos api - estos se encuentran en AlmacenRestContoller)
	private List<Almacen> getAlmacenes() {
		List<Almacen> almacenes = this.almacenServices.findAll();
		return almacenes;
	}

	public void run(String... args) {
		try{
			this.saveAlmacenInDB();
			List<Almacen> L= this.getAlmacenes();
			L.forEach(almacen -> logger.info(almacen.toString()));
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(AlmacenApplication.class, args);
	}

}
