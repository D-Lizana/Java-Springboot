package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {

    @GetMapping({"/hola", "/hm", "/hello"})
    public String holaMundo(){
        return "Hola, mundo.";
    }

}
