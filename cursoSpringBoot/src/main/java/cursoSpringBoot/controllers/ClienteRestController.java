package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        // Añadimos la clase ResponseEntity para conocer el status de la operacion
        return ResponseEntity.ok(clientes);
    }

    // En este caso añadimos value para coger la variable que vamos a utilizar
    //@RequestMapping(value = "/{nombreUsuario}", method = RequestMethod.GET)
    @GetMapping("/{nombreUsuario}")
    public ResponseEntity<?> getCliente(@PathVariable String nombreUsuario) {

        for (Cliente cliente : clientes) {
            if (cliente.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return ResponseEntity.ok(cliente);
            }
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con nombre de usuario: "+nombreUsuario);
        return ResponseEntity.notFound().build();
    }

    // Las anotaciones POST se usan para añadir nuevos datos
    //@RequestMapping( method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);

        // return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado con éxito.");
        // para POST la convención es retornar la URI del objeto creado

        URI ubicacion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nombreUsuario}")
                .buildAndExpand(cliente.getNombreUsuario())
                .toUri();

        return ResponseEntity.created(ubicacion).body(cliente);

    }


    // Las anotaciones PUT se usan para modificar o actualizar varios datos
    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Cliente cliente) {
        for (Cliente c : clientes) {
            if (cliente.getId() == c.getId()) {
                c.setNombre(cliente.getNombre());
                c.setNombreUsuario(cliente.getNombreUsuario());
                c.setContrasena(cliente.getContrasena());
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


    // Anotación DELETE para borrar datos de la bbdd
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                clientes.remove(c);
                //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente borrado con éxito.");
                return ResponseEntity.noContent().build();
            }
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con id: "+ id);
        return ResponseEntity.notFound().build();
    }

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Cliente cliente) {
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
                return ResponseEntity.ok("Cliente con ID: "+cliente.getId()+" modificado con éxito.");
            }
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con id: "+ cliente.getId());
        return ResponseEntity.notFound().build();
    }


}
