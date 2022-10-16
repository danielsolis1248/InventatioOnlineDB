package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.DatosPersonales;
import com.iunis.adventclub.domain.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatosPersonalesRepository extends CrudRepository<DatosPersonales,Long> {
}
