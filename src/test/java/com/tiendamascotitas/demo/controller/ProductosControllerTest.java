package com.tiendamascotitas.demo.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.List;

import org.hibernate.engine.internal.Collections;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.tiendamascotitas.demo.model.Producto;
import com.tiendamascotitas.demo.repository.PedidoRepository;
import com.tiendamascotitas.demo.repository.ProductosRepository;
import com.tiendamascotitas.demo.service.ProductoService;

@WebMvcTest(ProductosController.class)
public class ProductosControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductosRepository productosRepository;

    @MockBean
    private ProductoService productoServiceMock;
    private List<Producto> listaProductos;
    @BeforeEach
    public void setUp() {
        Producto producto = new Producto();
        producto.setId(1);
        producto.setNombre("Producto 1");
        producto.setDescripcion("Descripcion 1");

        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setNombre("Producto 2");
        producto2.setDescripcion("Descripcion 2");


        listaProductos = List.of(producto,producto2);
        when(productosRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(productosRepository.save(any(Producto.class))).thenReturn(producto);
    }

    @Test
    public void testGetAllProductos() throws Exception {
        List<Producto> productos = listaProductos;
        when(productoServiceMock.getAllProductos()).thenReturn(productos);
        mockMvc.perform(get("/productos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nombre").value("Producto 1"))
            .andExpect(jsonPath("$[0].descripcion").value("Descripcion 1"));
    }

    @Test
    public void testGetProductoById() {
        Optional<Producto> result = productosRepository.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Producto 1", result.get().getNombre());
    }

    @AfterEach
    public void tearDown() {
        reset(productoServiceMock);
    }

}
