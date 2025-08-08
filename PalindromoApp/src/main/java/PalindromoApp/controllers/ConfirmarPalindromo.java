package PalindromoApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfirmarPalindromo {

    @GetMapping("/palindromo/{frase}")
    public String confirmarPalindromo(@PathVariable String frase){
        String resultado = "";
        boolean palindromo = true;

        for(int i = 0; i<frase.length()/2; i++){
            if(frase.charAt(i) != frase.charAt((frase.length()-1)-i)){
                palindromo = false;
            }
        }

        if (palindromo){
            resultado = frase+ " es un palíndromo.";
        }
        else {
            resultado = frase+ " no es un palíndromo.";
        }

        return resultado;
    }
}
