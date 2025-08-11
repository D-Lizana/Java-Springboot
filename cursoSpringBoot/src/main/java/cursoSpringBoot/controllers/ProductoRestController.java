package cursoSpringBoot.controllers;


import cursoSpringBoot.domain.Producto;
import cursoSpringBoot.service.ProductoService;
import cursoSpringBoot.service.ProductosServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/productos")
public class ProductoRestController {

    ProductoService productosService = new ProductosServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProductos(){
        List<Producto> productos = productosService.getProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProducto(@PathVariable Integer id){
        Producto producto = productosService.getProducto(id);
        if (producto != null){
            return ResponseEntity.ok(producto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }



}
