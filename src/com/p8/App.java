package com.p8;

import java.util.Scanner;
import com.p8.Usuario;

public class App {
    public static void main(String[] args) {
        // Llamar a la clase Scanner de Java
        Scanner scanner = new Scanner(System.in);
        // Llamar a mi propia clase Usuario
        Usuario usuario1 = new Usuario(scanner);

        // Variable para validar que un usuario esté registrado
        String usuarioRegistrado = usuario1.registrarUsuario();
        // Imprimir el resultado del registro
        System.out.println("Usuario registrado: " + usuarioRegistrado);

        // Iniciar sesión
        System.out.println("Inicie sesion");
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contrasena: ");
        String password = scanner.nextLine();

        // Verificar las credenciales de inicio de sesión
        if (usuario1.iniciarSesion(username, password)) {
            System.out.println("Inicio de sesion exitoso.");
        } else {
            System.out.println("Inicio de sesion fallido.");
        }

        scanner.close(); // Importante cerrar el scanner
    }
}