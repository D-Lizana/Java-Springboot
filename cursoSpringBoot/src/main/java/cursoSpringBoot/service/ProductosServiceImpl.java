package cursoSpringBoot.service;

import cursoSpringBoot.domain.Producto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Lazy para que el servicio no se inicialice hasta que no sea necesario o utilizado
@Lazy
// Ahora hemos metido el nombre en la condicion en vez de en el servicio directamente
@Service//("listResourceService")
@ConditionalOnProperty(name = "service.producto", havingValue = "list")
public class ProductosServiceImpl implements ProductoService{

    List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto(1,"Hacha",20.0,3),
            new Producto(2,"Martillo",12.50,7)
    ));


    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public Producto getProducto(Integer id){
        for(Producto p: productos){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public Producto deleteProducto(Integer id){
        for(Producto p: productos){
            if (p.getId() == id){
                productos.remove(p);
                return p;
            }
        }
        return null;
    }

    @Override
    public Producto postProducto(Producto producto){
        productos.add(producto);
        return producto;
    }


}
