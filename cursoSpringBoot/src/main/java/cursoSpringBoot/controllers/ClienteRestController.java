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
    public List<Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{nombreUsuario}")
    public Cliente getCliente(@PathVariable String nombreUsuario){

        for(Cliente cliente: clientes){
            if(cliente.getNombreUsuario().equalsIgnoreCase(nombreUsuario)){
                return cliente;
            }
        }
        return null;
    }


    @PostMapping("/clientes/")
    public void postCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
    }



}
