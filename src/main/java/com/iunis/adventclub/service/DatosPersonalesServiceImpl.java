package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.DatosPersonales;
import com.iunis.adventclub.repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatosPersonalesServiceImpl implements DatosPersonalesService{

    @Autowired
    DatosPersonalesRepository datosPersonalesRepository;

    @Override
    public List<DatosPersonales> listDatosPersonales() {
        return null;
    }

    @Override
    public void createDatosPersonales(DatosPersonales datosPersonales) {

    }

    @Override
    public void deleteDatosPersonales(DatosPersonales datosPersonales) {

    }

    @Override
    public DatosPersonales findDatosPersonalesById(DatosPersonales datosPersonales) {
        return null;
    }

    @Override
    public List<DatosPersonales> findDatosPersonalesByStatusActivo() {
        System.out.println("paso 2");
        System.out.println("datosPersonalesRepository.findAll() = " + datosPersonalesRepository.findAll());
        return (List<DatosPersonales>) datosPersonalesRepository.findAll();
    }
}
