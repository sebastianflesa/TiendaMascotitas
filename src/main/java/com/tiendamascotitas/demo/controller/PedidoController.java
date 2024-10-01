package com.tiendamascotitas.demo.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<?> createPedido(@RequestBody Pedido pedido) {
        Pedido newPedido = pedidoService.crearPedido(pedido);
        EntityModel<Pedido> resource = EntityModel.of(newPedido);
        resource.add(linkTo(methodOn(PedidoController.class).getPedidoById(Long.valueOf(newPedido.getId()))).withSelfRel());
        resource.add(linkTo(methodOn(PedidoController.class).getPedidos()).withRel("all-pedidos"));
        return ResponseEntity.ok(resource);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedido = Optional.ofNullable(pedidoService.getPedidoById(id));
        if (pedido.empty() != null) {
            EntityModel<Pedido> resource = EntityModel.of(pedido.get());
            resource.add(linkTo(methodOn(PedidoController.class).getPedidoById(id)).withSelfRel());
            resource.add(linkTo(methodOn(PedidoController.class).getPedidos()).withRel("all-pedidos"));
            return ResponseEntity.ok(resource);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Pelicula no encontrada, quizás no es tan buena para estar en nuestra lista :(");
            map.put("status", "404");
            return ResponseEntity.status(200).body(map);

        }
    }

}
