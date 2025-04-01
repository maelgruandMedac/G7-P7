package com.p8;

public class Usuario {
    private String credenciales;
    private static final String SEPARADOR = ";";

    private Usuario(String username, String password) {
        this.credenciales = username.toLowerCase() + SEPARADOR + password;
    }

    public String getCredenciales() {
        String[] parts = credenciales.split(SEPARADOR);
        return parts[0].toLowerCase() + SEPARADOR + parts[1];
    }

    public boolean login(String usuarioLogin, String passwordLogin) {
        if (credenciales == null) {
            return false;
        }

        String[] parts = credenciales.split(SEPARADOR);
        String storedUsername = parts[0];
        String storedPassword = parts[1];

        return storedUsername.equalsIgnoreCase(usuarioLogin) && storedPassword.equals(passwordLogin);
    }

    public static Usuario registrar(String username, String password) {
        if (validarUsuario(username) && validarPassword(username, password)) {
            System.out.println("Registro exitoso.\n");
            return new Usuario(username.toLowerCase(), password);
        }
        return null;
    }

    public static boolean validarUsuario(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (username.contains(" ")) {
            return false;
        }
        if (!username.equalsIgnoreCase("administrador") && !username.startsWith("_")) {
            return false;
        }
        if (username.contains(SEPARADOR)) {
            return false;
        }
        return true;
    }

    public static boolean validarPassword(String username, String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        if (password.contains(" ")) {
            return false;
        }
        if (username.equalsIgnoreCase("administrador") && password.equalsIgnoreCase("admin")) {
            return false;
        }
        if (password.length() < 4) {
            return false;
        }
        if (username.equalsIgnoreCase(password)) {
            return false;
        }
        if (password.contains(SEPARADOR)) {
            return false;
        }
        return true;
    }
}