package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Status;
import com.iunis.adventclub.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    //public Optional<Usuario> findUsuarioByUsuario(String nombre);
    public Optional<Usuario> findUsuarioByUsername(String nombre);

    List<Usuario> findByStatus(Status status);

}
