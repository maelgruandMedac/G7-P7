package com.p8;

import java.util.Scanner;

 
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario1 = new Usuario(scanner);
        String usuarioRegistrado = usuario1.registrarUsuario();
        System.out.println("Usuario registrado: " + usuarioRegistrado);
        scanner.close(); // Importante cerrar el scanner
    }
}
