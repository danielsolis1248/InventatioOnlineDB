package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.DatosPersonales;

import java.util.List;

public interface DatosPersonalesService {

    public List<DatosPersonales> listDatosPersonales();

    public void createDatosPersonales(DatosPersonales datosPersonales);

    public void deleteDatosPersonales(DatosPersonales datosPersonales);

    public DatosPersonales findDatosPersonalesById(DatosPersonales datosPersonales);

    public List<DatosPersonales> findDatosPersonalesByStatusActivo();



}
