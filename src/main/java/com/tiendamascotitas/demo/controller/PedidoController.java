package com.tiendamascotitas.demo.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoService.getPedidos();
    }

    @GetMapping("/{id}/ubicacion")
    public ResponseEntity<?> getPedidoByID(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.getPedidoByID(id);
        
        if (pedido.isPresent()) {
            Map<String, Object> map = new HashMap<String, Object>();
            LocalDateTime fecha_actual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fecha_actual_formateada = fecha_actual.format(formato);
            map.put("id_pedido", pedido.get().getId());
            map.put("estado", pedido.get().getEstado());
            map.put("ubicacion", pedido.get().getUbicacion());
            map.put("direccion", pedido.get().getDireccion());
            map.put("fecha_actualizacion", fecha_actual_formateada);
            return ResponseEntity.ok(map);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "el pedido no existe :o");
            map.put("status", "404");
            return ResponseEntity.status(200).body(map);
        }
    }

    
}
