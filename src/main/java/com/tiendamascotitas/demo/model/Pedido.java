package com.tiendamascotitas.demo.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fechaPedido", nullable = false)
    private LocalDateTime fechaPedido;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "rutCliente", nullable = false)
    private String rutCliente;
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;
}