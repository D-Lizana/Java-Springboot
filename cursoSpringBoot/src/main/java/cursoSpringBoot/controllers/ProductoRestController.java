package cursoSpringBoot.controllers;


import cursoSpringBoot.configurations.ExternalizedConfigurations;
import cursoSpringBoot.domain.Producto;
import cursoSpringBoot.service.ProductoService;
import cursoSpringBoot.service.ProductosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController

@RequestMapping("/productos")
public class ProductoRestController {

    // Instancia de la clase para poder usar el metodo del servicio. Lo vamos a implementar inyectando directamente la dependencia por campo
    //ProductoService productosService = new ProductosServiceImpl();

    @Lazy
    @Autowired
    // @Qualifier tiene prioridad respecto a @Primary
    // @Qualifier("jsonResourceService") si usamos qualifier siempre se sobrepone a los otros metodos, incluido las propiedades de la aplicacion
    private ProductoService productosService;


    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;


    // Una dependencia porque depende de otro objeto para llevar a cabo su función
    @GetMapping
    public ResponseEntity<?> getProductos(){
        System.out.println(externalizedConfigurations.toString());
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
