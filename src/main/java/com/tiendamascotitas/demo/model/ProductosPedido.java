package com.tiendamascotitas.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos_pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id") // Clave foránea hacia la tabla 'productos'
    private Producto producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id") // Clave foránea hacia la tabla 'pedidos'
    private Pedido pedido;
    @JoinColumn(name = "cantidad") 
    private int cantidad; 
}
