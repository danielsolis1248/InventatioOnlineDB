package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Usuario;
import com.iunis.adventclub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void createUsuario(Usuario usuario) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usuario.setUserpassword(bCryptPasswordEncoder.encode((usuario.getUserpassword())));
        usuario.getDatosPersonales().setFechaRegistro(new Date());
        usuarioRepository.save(usuario);
    }

    @Override
    public void createUsuarioNoEncoder(Usuario usuario) {
        usuario.getDatosPersonales().setFechaRegistro(new Date());
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuario.setStatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId()).orElse(null);
    }

    @Override
    public List<Usuario> findUsuarioByStatusActivo() {
        return usuarioRepository.findByStatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }
}
