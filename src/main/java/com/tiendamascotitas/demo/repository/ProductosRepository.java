package com.tiendamascotitas.demo.repository;
import com.tiendamascotitas.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Producto, Long>{
    
}
