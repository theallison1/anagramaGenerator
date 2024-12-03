package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Generador de Anagramas ===");
        System.out.print("Ingrese un conjunto de letras (sin espacios ni caracteres especiales): ");
        String input = scanner.nextLine();

        // Validar la entrada
        if (!isValidInput(input)) {
            System.out.println("Error: La entrada debe contener al menos dos letras y no incluir números ni caracteres especiales.");
            return;
        }

        // Convertir la entrada en un arreglo de caracteres
        char[] letters = input.toCharArray();

        // Generar los anagramas
        List<String> anagrams = generateAnagrams(letters);

        // Imprimir los resultados
        System.out.println("Los anagramas son:");
        anagrams.forEach(System.out::println);
    }

    // Método para validar la entrada del usuario
    private static boolean isValidInput(String input) {
        return input != null && input.matches("[a-zA-Z]+") && input.length() >= 2;
    }

    // Método para generar todas las permutaciones de las letras
    private static List<String> generateAnagrams(char[] letters) {
        List<String> result = new ArrayList<>();
        permute(letters, 0, result);
        return result;
    }

    // Lógica recursiva para permutar las letras
    private static void permute(char[] letters, int start, List<String> result) {
        if (start == letters.length - 1) {
            result.add(new String(letters)); // Caso base: se encontró una permutación
            return;
        }

        for (int i = start; i < letters.length; i++) {
            swap(letters, start, i);           // Fijar una letra
            permute(letters, start + 1, result); // Recursión para el resto
            swap(letters, start, i);           // Backtracking: deshacer el intercambio
        }
    }

    // Método para intercambiar dos elementos en el arreglo
    private static void swap(char[] letters, int i, int j) {
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }
}
