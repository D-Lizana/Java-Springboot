package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(1, "Vanesa", "Vane", "contraseña1"),
            new Cliente(2, "Efren", "Efren", "contraseña2"),
            new Cliente(3, "Sara", "Sarita", "contraseña3"),
            new Cliente(4, "Diego", "Die", "contraseña4")
    ));

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clientes;
    }

    @GetMapping("/clientes/{nombreUsuario}")
    public Cliente getCliente(@PathVariable String nombreUsuario) {

        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return cliente;
            }
        }
        return null;
    }

    // Las anotaciones POST se usan para añadir nuevos datos
    @PostMapping("/clientes")
    public void postCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
    }

    // Las anotaciones PUT se usan para modificar o actualizar varios datos
    @PutMapping("/clientes")
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
    @DeleteMapping("/clientes/{id}")
    public void deleteMapping(@PathVariable int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                clientes.remove(c);
            }
        }
    }

    @PatchMapping("/clientes")
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
