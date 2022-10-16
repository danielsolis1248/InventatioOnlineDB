package com.iunis.adventclub.controller;


import com.iunis.adventclub.domain.DatosPersonales;
import com.iunis.adventclub.service.DatosPersonalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class EmpleadoController {
    private DatosPersonalesService datosPersonalesService;

    @GetMapping(value = "/empleadodisplay")
    public String empleadoDisplay(DatosPersonales datosPersonales, Model model){
        System.out.println("paso 1");
        datosPersonalesService.findDatosPersonalesByStatusActivo();
//        model.addAttribute("empleadoList",empleadoList);
        return "usuario";
    }

    @PostMapping(value = "/empleadocreate")
    public String empleadoCreate(DatosPersonales datosPersonales){
        datosPersonalesService.createDatosPersonales(datosPersonales);
        return "redirect:/empleadodisplay";
    }

    @GetMapping(value = "/empleadodelete")
    public String empleadoDelete(DatosPersonales datosPersonales){
        datosPersonales = datosPersonalesService.findDatosPersonalesById(datosPersonales);
        datosPersonalesService.deleteDatosPersonales(datosPersonales);
        return "redirect:/empleadodisplay";
    }


}
