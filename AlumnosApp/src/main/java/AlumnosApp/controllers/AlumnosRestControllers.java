package AlumnosApp.controllers;

import AlumnosApp.domain.Alumno;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/{id}")
    public void putAlumno(@RequestBody Alumno alumno){
        for(Alumno a: alumnos){
            if(alumno.getId() == a.getId()){
                a.setNombre(alumno.getNombre());
                a.setEmail(alumno.getEmail());
                a.setEdad(alumno.getEdad());
                a.setCurso(alumno.getCurso());
            }
        }
    }

    @PatchMapping
    public void patchAlumno(@RequestBody Alumno alumno){
        for(Alumno a: alumnos){
            if(alumno.getId() == a.getId()){
                if (alumno.getNombre() != null){
                    a.setNombre(alumno.getNombre());
                }
                if (alumno.getEmail() != null){
                    a.setEmail(alumno.getEmail());
                }
                if (alumno.getEdad() != null){
                    a.setEdad(alumno.getEdad());
                }
                if (alumno.getCurso() != null){
                    a.setCurso(alumno.getCurso());
                }
            }
        }
    }


    @PostMapping
    public void postAlumno(@RequestBody Alumno alumno){
        alumnos.add(alumno);
    }


    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable int id){
        for(Alumno a: alumnos){
            if(id == a.getId()){
                alumnos.remove(a);
            }
        }
    }


}
