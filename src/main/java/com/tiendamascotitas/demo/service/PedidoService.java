package com.tiendamascotitas.demo.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.model.Producto;
import com.tiendamascotitas.demo.model.ProductosPedido;


@Service
public interface PedidoService {
    public List<Pedido> getAllPedidos();
    public ProductosPedido createPedidoProductos(ProductosPedido productosPedido);
    public Pedido crearPedido(Pedido pedido);
}
