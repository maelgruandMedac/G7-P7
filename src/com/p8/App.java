package com.p8;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = null; 
        boolean resultadoLogin;

        // Registro del usuario
        do {
            System.out.println("=== REGISTRO ===");
            System.out.print("Usuario: ");
            String usuarioRegistro = scanner.nextLine().trim(); // Supprimer les espaces
            System.out.print("Contraseña: ");
            String passwordRegistro = scanner.nextLine().trim(); // Supprimer les espaces

            usuario = Usuario.registrar(usuarioRegistro, passwordRegistro);

            if (usuario != null) {
                System.out.println("Registro exitoso.");
            } else {
                System.out.println("Registro fallido. Por favor, intente de nuevo.");
            }
        } while (usuario == null);

        // Inicio de sesión del usuario
        do {
            System.out.println("=== INICIO DE SESIÓN ===");
            System.out.print("Usuario: ");
            String usuarioLogin = scanner.nextLine().trim(); // Supprimer les espaces
            System.out.print("Contraseña: ");
            String passwordLogin = scanner.nextLine().trim(); // Supprimer les espaces

            resultadoLogin = usuario.login(usuarioLogin, passwordLogin);

            if (!resultadoLogin) {
                System.out.println("Inicio de sesión fallido. Por favor, intente de nuevo.");
            }
        } while (!resultadoLogin);

        System.out.println("Inicio de sesión exitoso.");
        scanner.close();
    }
}