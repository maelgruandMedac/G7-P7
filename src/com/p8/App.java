package com.p8;

import java.util.Scanner;
import com.p8.Usuario;
 
public class App {
    public static void main(String[] args) {
        // Llamar a la clase Scanner de Java
        Scanner scanner = new Scanner(System.in);
        // Llamar a mi propia clase Usuario
        Usuario usuario1 = new Usuario(scanner);
        // Variable para validar que una usuario este registrado
        String usuarioRegistrado = usuario1.registrarUsuario();
        // Imprimir le resultado
        System.out.println("Usuario registrado: " + usuarioRegistrado);
        scanner.close(); // Importante cerrar el scanner
    }
}

