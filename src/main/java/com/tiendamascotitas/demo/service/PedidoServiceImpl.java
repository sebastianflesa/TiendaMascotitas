package com.tiendamascotitas.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.model.ProductosPedido;
import com.tiendamascotitas.demo.repository.PedidoRepository;
import com.tiendamascotitas.demo.repository.ProductosPedidoRepository;
import com.tiendamascotitas.demo.service.PedidoService;

//import com.cine.demo.model.Pelicula;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

@Service
public class PedidoServiceImpl implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;
    private ProductosPedidoRepository productosPedidoRepository;
    
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public ProductosPedido createPedidoProductos(ProductosPedido productosPedido) {
        return productosPedidoRepository.save(productosPedido);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).get();
    }


    
}