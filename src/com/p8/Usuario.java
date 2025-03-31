package com.p8;

import java.util.Scanner;

public class Usuario {
    private String nombreUsuario;
    private Scanner sc;
    private static final String ADMIN = "administrador";
    private static final String ERROR_ESPACIO = "El nombre de usuario y la contrasena no deben contener espacios.";
    private static final String ERROR_ADMIN = "La contrasena no puede ser 'admin' si el usuario es 'administrador'.";
    private static final String ERROR_LONGITUD = "La contrasena debe tener al menos 4 caracteres.";
    private static final String ERROR_IDENTICO = "El nombre de usuario y la contrasena no pueden ser identicos (insensible a mayusculas y minusculas).";
    private static final String ERROR_CARACTER_ESPECIAL = "El nombre de usuario o la contrasena contiene un caracter no valido.";

    public Usuario(Scanner scan) {
        this.sc = scan;
    }

    public void setNombreUsuario(String username) {
        this.nombreUsuario = username;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Scanner getScanner() {
        return sc;
    }

    public String solicitarNombreUsuario() {
        String username;
        while (true) {
            System.out.print("Ingrese el nombre de usuario: ");
            username = sc.nextLine();
            if (validarNombreUsuario(username)) {
                return username;
            }
        }
    }

    private boolean validarNombreUsuario(String username) {
        if (username.contains(" ")) {
            System.out.println(ERROR_ESPACIO);
            return false;
        }
        if (!username.startsWith("_") && !username.equalsIgnoreCase(ADMIN)) {
            System.out.println("El nombre de usuario debe comenzar con '_' excepto para 'administrador'.");
            return false;
        }
        if (!username.matches("[a-zA-Z0-9_]+")) {
            System.out.println(ERROR_CARACTER_ESPECIAL);
            return false;
        }
        return true;
    }

    public String solicitarContrasena(String username) {
        String password;
        while (true) {
            System.out.print("Ingrese la contrasena: ");
            password = sc.nextLine();
            if (validarContrasena(username, password)) {
                return password;
            }
        }
    }

    private boolean validarContrasena(String username, String password) {
        if (password.contains(" ")) {
            System.out.println(ERROR_ESPACIO);
            return false;
        }
        if (username.equalsIgnoreCase(ADMIN) && password.equalsIgnoreCase("admin")) {
            System.out.println(ERROR_ADMIN);
            return false;
        }
        if (password.length() < 4) {
            System.out.println(ERROR_LONGITUD);
            return false;
        }
        if (username.equalsIgnoreCase(password)) {
            System.out.println(ERROR_IDENTICO);
            return false;
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            System.out.println(ERROR_CARACTER_ESPECIAL);
            return false;
        }
        return true;
    }

    public String registrarUsuario() {
        String username = solicitarNombreUsuario();
        String password = solicitarContrasena(username);
        return username + ":" + password;
    }
}