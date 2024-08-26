package com.tiendamascotitas.demo.model;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor

public class Pedido {
    private int id;
    private LocalDateTime fecha_pedido;
    private String direccion;
    private String estado;
    private String rut_cliente;
    private List<Producto> productos;
    private String ubicacion;
}
