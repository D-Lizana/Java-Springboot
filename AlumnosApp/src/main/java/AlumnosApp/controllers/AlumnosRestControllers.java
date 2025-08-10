package AlumnosApp.controllers;

import AlumnosApp.domain.Alumno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController

@RequestMapping("/alumnos")
public class AlumnosRestControllers {

    private List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(1,"Diego", "@myuax.es",32,"DAM")
    ));


    @GetMapping
    public List<Alumno> getAlumnos(){
        return alumnos;
    }


    @GetMapping("/{email}")
    public  Alumno getAlumnoPorEmail(@PathVariable String email){
        for(Alumno a: alumnos){
            if(a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }






}
