package cursoSpringBoot.controllers;


import cursoSpringBoot.domain.Producto;
import cursoSpringBoot.service.ProductoService;
import cursoSpringBoot.service.ProductosServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id){
        Producto producto = productosService.getProducto(id);
        if (producto != null){
            return ResponseEntity.ok(producto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> postProducto(@RequestBody Producto productoNuevo){
        Producto producto = productosService.postProducto(productoNuevo);

        URI ubicacion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nombreUsuario}")
                .buildAndExpand(producto.getNombre())
                .toUri();

        return ResponseEntity.created(ubicacion).body(producto);
    }




}
