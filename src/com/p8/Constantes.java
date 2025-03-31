package com.p8;
public enum Constantes {
    ADMIN("administrador"),
    ERROR_ESPACIO("El nombre de usuario y la contrasena no deben contener espacios."),
    ERROR_ADMIN("La contrasena no puede ser 'admin' si el usuario es 'administrador'."),
    ERROR_LONGITUD("La contrasena debe tener al menos 4 caracteres."),
    ERROR_IDENTICO("El nombre de usuario y la contrasena no pueden ser identicos (insensible a mayusculas y minusculas)."),
    ERROR_CARACTER_ESPECIAL("El nombre de usuario o la contrasena contiene un caracter no valido.");

    private final String valeur;

    Constantes(String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }
}