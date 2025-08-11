package cursoSpringBoot.service;

import cursoSpringBoot.domain.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductosServiceImpl {

    List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto(001,"Hacha",20.0,3),
            new Producto(002,"Martillo",12.50,7)
    ));





}
