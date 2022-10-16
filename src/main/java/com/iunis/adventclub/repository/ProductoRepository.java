package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Producto;
import com.iunis.adventclub.domain.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long> {
    List<Producto> findByStatus(Status status);

}

