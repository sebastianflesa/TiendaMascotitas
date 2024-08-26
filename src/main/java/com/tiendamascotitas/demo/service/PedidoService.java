package com.tiendamascotitas.demo.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.tiendamascotitas.demo.model.Pedido;
import com.tiendamascotitas.demo.model.Producto;

@Service
public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    
    
    public PedidoService() {

        pedidos.add(new Pedido(
            540, 
            LocalDateTime.of(2024, 8, 25, 20, 30),
            "Las calilas 750, Viña del mar, Valparaiso",
            "En camino",
            "12345678-9",
            Arrays.asList(new Producto(20, "Alimento ACME", "El más sabroso"), new Producto(21, "Arnes de perrito", "Un arnes bonito")),
            "Camion despacho 5"
        ));

        pedidos.add(new Pedido(
            541, 
            LocalDateTime.of(2024, 8, 21, 15, 45),
            "Los sauces 123, Santiago, Metropolitana",
            "En proceso",
            "87654321-0",
            Arrays.asList(new Producto(22, "Collar luminoso", "Perfecto para la noche"), 
                          new Producto(23, "Juguete mordedor", "Ideal para cachorros")),
            "Sucursal #1"
        ));

        pedidos.add(new Pedido(
            542, 
            LocalDateTime.of(2024, 8, 24, 10, 15),
            "Calle falsa 123, La Serena, Coquimbo",
            "Entregado",
            "11223344-5",
            Arrays.asList(new Producto(24, "Cama de perro", "Muy cómoda y resistente"), 
                          new Producto(25, "Correa retráctil", "Para paseos largos y perros locos")),
            "Entregado en direccion"
        ));

        pedidos.add(new Pedido(
            543, 
            LocalDateTime.of(2024, 8, 24, 9, 30),
            "Avenida central 450, Concepción, Biobío",
            "Entregado",
            "55443322-1",
            Arrays.asList(new Producto(26, "Transportadora", "Espaciosa y segura"), 
                          new Producto(27, "Peine para mascotas", "Mantiene el pelaje saludable")),
            "Entregado en direccion"
        ));

        pedidos.add(new Pedido(
            544, 
            LocalDateTime.of(2024, 8, 25, 14, 50),
            "Calle principal 789, Temuco, Araucanía",
            "En camino",
            "33445566-7",
            Arrays.asList(new Producto(28, "Rascador para gatos", "Resistente y duradero"), 
                          new Producto(29, "Arena para gatos", "Es arena de gato")),
            "Camion despacho 5"
        ));

    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Optional<Pedido> getPedidoByID(Integer id) {
        return pedidos.stream().filter(p -> Integer.valueOf(p.getId()).equals(id)).findFirst();
    }

}
