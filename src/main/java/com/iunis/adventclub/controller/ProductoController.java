package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.DatosPersonales;
import com.iunis.adventclub.domain.Producto;
import com.iunis.adventclub.service.DatosPersonalesService;
import com.iunis.adventclub.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping(value = "/productodisplay")
    public String productoDisplay(Producto producto, Model model){
        Iterable<Producto> productoList = productoService.findProductoByStatusActivo();
        model.addAttribute("productoList",productoList);

        //Mandanvo un productoupdate vacio para evitar error en el modal
        model.addAttribute("productoUpdate", producto);
        return "producto";
    }

    @PostMapping(value = "/productocreate")
    public String productoCreate(Producto producto){
        productoService.createProducto(producto);
        return "redirect:/productodisplay";
    }

    @GetMapping(value = "/productodelete")
    public String productoDelete(Producto producto){
        producto = productoService.findProductoById(producto);
        productoService.deleteProducto(producto);
        return "redirect:/productodisplay";
    }

    @GetMapping(value = "/productoupdate")
    public String productoUpdate(Producto producto, Producto idproducto, Model model) {
        Producto productoFull = productoService.findProductoById(idproducto);
        model.addAttribute("productoUpdate", productoFull);

        Iterable<Producto> productoList = productoService.findProductoByStatusActivo();
        model.addAttribute("productoList",productoList);
        return "producto";
    }


}
