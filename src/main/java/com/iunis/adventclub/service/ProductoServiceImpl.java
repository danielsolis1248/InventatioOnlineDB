package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Producto;
import com.iunis.adventclub.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<Producto> listProducto() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void createProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        producto.setStatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        productoRepository.save(producto);
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return productoRepository.findById(producto.getId()).orElse(null);
    }

    @Override
    public List<Producto> findProductoByStatusActivo() {
        return productoRepository.findByStatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }
}
