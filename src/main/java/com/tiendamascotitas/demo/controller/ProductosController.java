package com.tiendamascotitas.demo.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.model.Producto;
import com.tiendamascotitas.demo.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductoService productosService;
    
    @GetMapping
    public List<Producto> getAllProductos() {
        return productosService.getAllProductos();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productosService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productosService.updateProducto(id, producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoByID(@PathVariable Long id) {
        Optional<Producto> producto = productosService.getProductoByID(id);
        
        if (producto.isPresent()) {
            EntityModel<Producto> resource = EntityModel.of(producto.get());
            resource.add(linkTo(methodOn(ProductosController.class).getProductoByID(id)).withSelfRel());
            resource.add(linkTo(methodOn(ProductosController.class).getAllProductos()).withRel("all-productos"));
            return ResponseEntity.ok(resource);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "el Producto no existe :o");
            map.put("status", "404");
            return ResponseEntity.status(200).body(map);
        }
    }

    @DeleteMapping("/{id}")
    public Producto deletePedido(@PathVariable Long id) {
        return productosService.deletePedido(id);
    }


    
}
