package com.tiendamascotitas.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tiendamascotitas.demo.model.ProductosPedido;

public interface ProductosPedidoRepository extends JpaRepository<ProductosPedido, Long>{
    
}