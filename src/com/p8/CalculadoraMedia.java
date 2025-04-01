package com.p8;

import java.util.HashMap;
import java.util.Scanner;

public class CalculadoraMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> calificaciones = new HashMap<>();

        while (true) {
            double nota = -1;
            System.out.print("Introduce el nombre de la asignatura: ");
            String asignatura = scanner.nextLine();
            System.out.print("Introduce la nota para " + asignatura + " (entre 1 y 10): ");
            if (scanner.hasNextDouble()) {
                nota = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                if (nota < 1 || nota > 10) {
                    break;
                }
            } else {
                System.out.println("Entrada inválida. Introduce un número.");
                scanner.nextLine(); // Limpiar la entrada inválida
            }
            calificaciones.put(asignatura, nota);
        }

        // Mostrar las calificaciones actuales
        System.out.println("Notas actuales: " + calificaciones);

        System.out.print("¿Quieres modificar alguna calificación? (si/no): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("¿Cuál asignatura quieres modificar? ");
            String asignaturaModificar = scanner.nextLine();

            if (calificaciones.containsKey(asignaturaModificar)) {
                double nuevaNota;
                while (true) {
                    System.out.print("Nuevo valor para la nota de " + asignaturaModificar + ": ");
                    if (scanner.hasNextDouble()) {
                        nuevaNota = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        if (nuevaNota >= 1 && nuevaNota <= 10) {
                            break;
                        } else {
                            System.out.println("Nota inválida. Debe estar entre 1 y 10.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Introduce un número.");
                        scanner.nextLine(); // Limpiar la entrada inválida
                    }
                }
                calificaciones.put(asignaturaModificar, nuevaNota);
            } else {
                System.out.println("Asignatura no encontrada.");
            }
        }

        // Calcular la media de las calificaciones
        double suma = 0;
        for (double nota : calificaciones.values()) {
            suma += nota;
        }
        double media = suma / calificaciones.size();
        System.out.println("Tu media es: " + media);

        // Mostrar las notas finales
        System.out.println("Notas finales: " + calificaciones);

        scanner.close();
    }
}