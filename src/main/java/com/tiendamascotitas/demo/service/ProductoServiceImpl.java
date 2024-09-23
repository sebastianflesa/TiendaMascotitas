package com.tiendamascotitas.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.model.Producto;
import com.tiendamascotitas.demo.repository.ProductosRepository;

@Service
public class ProductoServiceImpl  implements ProductoService {
    @Autowired
    private ProductosRepository productosRepository;


    @Override
    public List<Producto> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productosRepository.save(producto);
    }

    
    @Override
    public Optional<Producto> getProductoByID(Long id) {
        if (productosRepository.findById(id).isEmpty()) {
            return Optional.ofNullable(new Producto());
        }
        return productosRepository.findById(id);
    }
    
    @Override
    public Producto updateProducto(Long id, Producto producto) {
       if(productosRepository.existsById(id)){
        producto.setId(id.intValue());
            return productosRepository.save(producto);
       }else{
            throw new IllegalArgumentException("Producto no encontrada");
       }
               
    }

    @Override
    public Producto deletePedido(Long id) {
        Optional<Producto> producto = productosRepository.findById(id);
        if (producto.isPresent()) {
            productosRepository.deleteById(id);
            return producto.get();
        } else {
            throw new IllegalArgumentException("Producto no encontrado");
        }
    }

    
}
