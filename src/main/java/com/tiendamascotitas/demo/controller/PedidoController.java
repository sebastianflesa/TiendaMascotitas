package com.tiendamascotitas.demo.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.model.ProductosPedido;
import com.tiendamascotitas.demo.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoService.getAllPedidos();
    }

    @PostMapping("/crear_pedido_productos")
    public ProductosPedido createPedidoProductos(@RequestBody ProductosPedido productosPedido) {
        return pedidoService.createPedidoProductos(productosPedido);
    }
    
    @PostMapping("/crear_pedido")
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }
}
