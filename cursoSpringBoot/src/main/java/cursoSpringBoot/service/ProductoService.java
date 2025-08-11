package cursoSpringBoot.service;

import cursoSpringBoot.domain.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos();

    public Producto getProducto(Integer id);

    public Producto deleteProducto(Integer id);

    public Producto postProducto(Producto producto);
}
