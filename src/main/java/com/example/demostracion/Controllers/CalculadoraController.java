package com.example.demostracion.Controllers;

import com.example.demostracion.Tools.Calculadora;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @PostMapping("/expresion")
    public String calcularInfix(@RequestBody String infix){

        String postfix = Calculadora.convertirAPostfix(infix);

        String resultado =
                Calculadora.resolverExpresionPostfix(postfix);

        return resultado;
    }
}