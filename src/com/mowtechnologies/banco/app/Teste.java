package com.mowtechnologies.banco.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        List<String> numerosComoTexto = numeros.stream()
                .map(String::valueOf) // Transforma Integer em String
                .collect(Collectors.toList());

        System.out.println(numerosComoTexto); // Saída: ["1", "2", "3", "4", "5"]
    }
}
