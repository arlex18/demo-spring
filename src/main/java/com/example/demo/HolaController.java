package com.example.demo;

// import: trae las anotaciones de Spring que vamos a usar abajo
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Trae la anotacion @PathVariable
import org.springframework.web.bind.annotation.PathVariable;
// Trae la clase Map, que usamos para guardar pares clave -> valor
import java.util.Map;

//@RestController: le dice a Spring "esta clase atiende peticiones web
// y devuelve los datos directamente como respuesta"
@RestController
public class HolaController {

    //@GetMapping("/hola"): cuando llegue una peticion GET a la ruta /hola,
    //Spring ejecuta el metodo que esta justo debajo
    @GetMapping("/hola")
    // public String: el metodo es publico y devuelve un texto (String)
    // saludar(): el nombre del metodo (lo elegimos nosotros)
    public String saludar() {
        // return: lo que escribamos aqui es lo que el navegador va a mostrar
        return "¡Hola desde Spring Boot!";
    }

    // @GetMapping("/saludo/{nombre}"): atiende peticiones GET a la ruta /saludo/ seguida de un valor.
    // {nombre} es una variable: lo que el cliente escriba ahi lo recibe el nombre
    @GetMapping("/saludo/{nombre}")
    //@PathVariable: toma el valor que viene en la URL y lo guarda en el parametro "nombre"
    public String saludoPersonalizado(@PathVariable String nombre) {
        // "Hola, " + nombre + "!": une (concatena) textos para armar el saludo
        return "Hola, " + nombre + "!";
    }

    // @GetMapping("/info"): atiende peticiones GET a la ruta /info
    @GetMapping("/info")
    // Map<String, Object>: una estructura de pares clave -> valor.
    // La clave es un texto (String) y el valor puede ser de cualquier tipo (Object)
    public Map<String, Object> info() {
        // Map.of(...): crea el mapa con los pares clave, valor, uno tras otro
        return Map.of(
                "curso", "Java con Spring Boot",  // clave "curso", valor texto
                "sesion", 1,                      // clave "sesion", valor número
                "activo", true                    // clave "activo", valor verdadero
        );
    }

    // atiende peticiones GET a /despedida seguida de un nombre
    // recibe el nombre de la URL y devuelve una despedida con ese nombre
    @GetMapping("/despedida/{nombre}")
    // explica que recibe y que devuelve el metodo
    public String despedida(@PathVariable String nombre) {
        // Comentario: explica que la despedida seguida de nombre
        return "Hasta luego, " + nombre;

    }

    // atiende peticiones GET a / un JSON con nombre,ciudad, y leguaje favorito
    @GetMapping("/perfil")
    // Map.of arma los pares clave y valor que se convierten en JSON.
    public Map<String, Object> datos() {
        // Comentario: explica qué hace Map.of
        return Map.of(
                "nombre", "Arlex",            // comentario: qué dato es este
                "ciudad", "Bogota",            // comentario: qué dato es este
                "lenguajeFavorito", "español"   // este es el último par: no lleva coma
        );
    }

    // atiende peticiones GET a /suma seguida de dos números, por ejemplo /suma/5/3
    @GetMapping("/suma/{a}/{b}")
    // recibe dos números enteros de la URL (a y b) y devuelve un entero: su suma
    public int operacion(@PathVariable int a, @PathVariable int b) {
        // suma los dos números que llegaron; con números, el + suma de verdad
        return a + b;
    }
}