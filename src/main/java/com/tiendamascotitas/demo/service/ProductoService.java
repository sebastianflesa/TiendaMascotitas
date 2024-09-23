package com.tiendamascotitas.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.tiendamascotitas.demo.model.Producto;
@Service
public interface ProductoService {
    List<Producto> getAllProductos();
    Producto createProducto(Producto producto);
    Producto updateProducto(Long id,Producto producto);
    Optional<Producto> getProductoByID(Long id);
    Producto deletePedido(Long id);
    
}
