package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

// Aqui lo añadimos a nivel de clase
@RequestMapping("/clientes")
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(1, "Vanesa", "Vane", "contraseña1"),
            new Cliente(2, "Efren", "Efren", "contraseña2"),
            new Cliente(3, "Sara", "Sarita", "contraseña3"),
            new Cliente(4, "Diego", "Die", "contraseña4")
    ));

    // Sustituye a getMapping de forma que si se hace una request GET, el metodo que se selecciona es este
    // El uso de @GetMapping o este depende de las caracteristicas o preferencias del proyecto
    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> getClientes() {
        return clientes;
    }

    // En este caso añadimos value para coger la variable que vamos a utilizar
    @RequestMapping(value = "/{nombreUsuario}", method = RequestMethod.GET)
    //@GetMapping("/{nombreUsuario}")
    public Cliente getCliente(@PathVariable String nombreUsuario) {

        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return cliente;
            }
        }
        return null;
    }

    // Las anotaciones POST se usan para añadir nuevos datos
    @PostMapping
    public void postCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
    }

    // Las anotaciones PUT se usan para modificar o actualizar varios datos
    @PutMapping
    public void putCliente(@RequestBody Cliente cliente) {
        for (Cliente c : clientes) {
            if (cliente.getId() == c.getId()) {
                c.setNombre(cliente.getNombre());
                c.setNombreUsuario(cliente.getNombreUsuario());
                c.setContrasena(cliente.getContrasena());
            }
        }
    }

    // Anotación DELETE para borrar datos de la bbdd
    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                clientes.remove(c);
            }
        }
    }

    @PatchMapping
    public void patchCliente(@RequestBody Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId() == cliente.getId()) {
                if (cliente.getNombre() != null) {
                    c.setNombre(cliente.getNombre());
                }
                if (cliente.getNombreUsuario() != null) {
                    c.setNombreUsuario(cliente.getNombreUsuario());
                }
                if (cliente.getContrasena() != null) {
                    c.setContrasena(cliente.getContrasena());
                }
            }
        }
    }


}
