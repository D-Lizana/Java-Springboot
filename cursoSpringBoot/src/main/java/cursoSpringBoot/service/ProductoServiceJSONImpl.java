package cursoSpringBoot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringBoot.domain.Producto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service("jsonResourceService")
public class ProductoServiceJSONImpl implements ProductoService{


    @Override
    public List<Producto> getProductos() {
        List<Producto> productos;

        try{
            // usamos objectmapper desde la biblioteca jackson
            // nos pide dos parametros: el fichero .json y el tipo de archivo donde se van a almacenar
            productos = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("productos.json"),
                            new TypeReference<List<Producto>>() {}
                    );
            // Almacenamos los datos en la lista productos y la retornamos
            return productos;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Producto getProducto(Integer id) {
        return null;
    }

    @Override
    public Producto deleteProducto(Integer id) {
        return null;
    }

    @Override
    public Producto postProducto(Producto producto) {
        return null;
    }
}
