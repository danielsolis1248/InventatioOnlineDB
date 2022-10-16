package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Producto;
import com.iunis.adventclub.domain.Usuario;
import com.iunis.adventclub.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuariodisplay")
    public String empleadoDisplay(Usuario usuario, Model model){
        Iterable<Usuario> usuarioList = usuarioService.findUsuarioByStatusActivo();
        model.addAttribute("usuarioList",usuarioList);

        //Mandamos un usuarioUpdate vacio para evitar errores en el modal
        model.addAttribute("usuarioUpdate", usuario);
        return "usuario";
    }

    @PostMapping(value = "/usuariocreate")
    public String usuarioCreate(Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return "redirect:/usuariodisplay";
    }

    @PostMapping(value = "/usuariocreatenoencoder")
    public String usuarioCreateNoEncoder(Usuario usuario) {
        usuarioService.createUsuarioNoEncoder(usuario);
        return "redirect:/usuariodisplay";
    }


    @GetMapping(value = "/usuariodelete")
    public String usuariodelete (Usuario usuario) {
        usuario = usuarioService.findUsuarioById(usuario);
        usuarioService.deleteUsuario(usuario);
        return "redirect:/usuariodisplay";
    }

    @GetMapping(value = "/usuarioupdate")
    public String usuarioUpdate(Usuario usuario, Usuario idusuario, Model model) {
        Usuario usuarioFull = usuarioService.findUsuarioById(idusuario);
        model.addAttribute("usuarioUpdate", usuarioFull);

        Iterable<Usuario> usuarioList = usuarioService.findUsuarioByStatusActivo();
        model.addAttribute("usuarioList",usuarioList);
        return "usuario";
    }


}
