package com.p8;

import java.util.Scanner;
import com.p8.Constantes;

public class Usuario {
    private String nombreUsuario;
    private Scanner sc;

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
            System.out.println(Constantes.ERROR_ESPACIO.getValeur());
            return false;
        }
        if (!username.startsWith("_") && !username.equalsIgnoreCase(Constantes.ADMIN.getValeur())) {
            System.out.println("El nombre de usuario debe comenzar con '_' excepto para 'administrador'.");
            return false;
        }
        if (!username.matches("[a-zA-Z0-9_]+")) {
            System.out.println(Constantes.ERROR_CARACTER_ESPECIAL.getValeur());
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
            System.out.println(Constantes.ERROR_ESPACIO.getValeur());
            return false;
        }
        if (username.equalsIgnoreCase(Constantes.ADMIN.getValeur()) && password.equalsIgnoreCase("admin")) {
            System.out.println(Constantes.ERROR_ADMIN.getValeur());
            return false;
        }
        if (password.length() < 4) {
            System.out.println(Constantes.ERROR_LONGITUD.getValeur());
            return false;
        }
        if (username.equalsIgnoreCase(password)) {
            System.out.println(Constantes.ERROR_IDENTICO.getValeur());
            return false;
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            System.out.println(Constantes.ERROR_CARACTER_ESPECIAL.getValeur());
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