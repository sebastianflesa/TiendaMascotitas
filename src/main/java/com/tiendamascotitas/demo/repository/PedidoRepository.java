package com.tiendamascotitas.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tiendamascotitas.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}