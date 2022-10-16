package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> listProducto();

    public void createProducto(Producto producto);

    public void deleteProducto(Producto producto);

    public Producto findProductoById(Producto producto);

    public List<Producto> findProductoByStatusActivo();

}
