package cursoSpringBoot.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoRestController {

    @GetMapping({"/saludo/{name}", "/hola/{name}"})
    public String saludo(@PathVariable String name){
        return "Hola, " + name;
    }

}
