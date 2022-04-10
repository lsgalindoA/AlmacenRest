package com.almacen.Almacen.Controller;

import com.almacen.Almacen.Entity.Almacen;
import com.almacen.Almacen.Service.AlmacenServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AlmacenController {

    private AlmacenServices almacenServices;

    public AlmacenController(AlmacenServices almacenServices) {
        this.almacenServices = almacenServices;
    }

    @RequestMapping("/")
    public String Index(Model model) {
        List<Almacen> list=almacenServices.findAll();
        model.addAttribute("lista", list);
        return "";
    }



}
