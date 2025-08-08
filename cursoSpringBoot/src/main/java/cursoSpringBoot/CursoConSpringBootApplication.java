package cursoSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Se usa @SpringBootApplication para marcar la clase principal de la aplicacion en Spring Boot
// @RestController se usa para marcar la clase de Java como un controlador REST
// combina @Controller y @ResponseBody para manejar solicitudes HTTP y devolver datos en json o xml. Permite crear controlladores.
// @GetMapping se usa para mapear las solicitudes HTTP GET, asigna la URL especificada a un metodo


@SpringBootApplication
public class CursoConSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(CursoConSpringBootApplication.class, args);






	}

}
