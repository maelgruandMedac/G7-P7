package com.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.p8.Usuario;

public class UsuarioTest {

    @Test
    public void testRegistrar_Valide() {
        Usuario usuario = Usuario.registrar("_testUser", "pass123");
        assertNotNull(usuario);
        assertEquals("_testuser;pass123", usuario.getCredenciales());
    }

    @Test
    public void testRegistrar_Invalide_NomUtilisateurVide() {
        Usuario usuario = Usuario.registrar("", "pass123");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_MotDePasseVide() {
        Usuario usuario = Usuario.registrar("_testUser", "");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_NomUtilisateurEspaces() {
        Usuario usuario = Usuario.registrar("test User", "pass123");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_NomUtilisateurSansUnderscore() {
        Usuario usuario = Usuario.registrar("testUser", "pass123");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_NomUtilisateurAdministrateurMotDePasseAdmin() {
        Usuario usuario = Usuario.registrar("administrador", "admin");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_MotDePasseTropCourt() {
        Usuario usuario = Usuario.registrar("_testUser", "pass");
        assertNotNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_MotDePasseIdentiqueUtilisateur() {
        Usuario usuario = Usuario.registrar("_testUser", "_testUser");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_NomUtilisateurSeparateur() {
        Usuario usuario = Usuario.registrar("test;User", "pass123");
        assertNull(usuario);
    }

    @Test
    public void testRegistrar_Invalide_MotDePasseSeparateur() {
        Usuario usuario = Usuario.registrar("_testUser", "pass;123");
        assertNull(usuario);
    }

    @Test
    public void testLogin_Valide() {
        Usuario usuario = Usuario.registrar("_testUser", "pass123");
        assertTrue(usuario.login("_testUser", "pass123"));
    }

    @Test
    public void testLogin_Invalide_NomUtilisateurIncorrect() {
        Usuario usuario = Usuario.registrar("_testUser", "pass123");
        assertFalse(usuario.login("wrongUser", "pass123"));
    }

    @Test
    public void testLogin_Invalide_MotDePasseIncorrect() {
        Usuario usuario = Usuario.registrar("_testUser", "pass123");
        assertFalse(usuario.login("_testUser", "wrongPass"));
    }

    @Test
    public void testLogin_Valide_NomUtilisateurMajuscules() {
        Usuario usuario = Usuario.registrar("_testUser", "pass123");
        assertTrue(usuario.login("_TESTUSER", "pass123"));
    }

    @Test
    public void testValidarUsuario_Valide() {
        assertTrue(Usuario.validarUsuario("_testUser"));
    }

    @Test
    public void testValidarUsuario_Invalide_Vide() {
        assertFalse(Usuario.validarUsuario(""));
    }

    @Test
    public void testValidarUsuario_Invalide_Espaces() {
        assertFalse(Usuario.validarUsuario("test User"));
    }

    @Test
    public void testValidarUsuario_Invalide_SansUnderscore() {
        assertFalse(Usuario.validarUsuario("testUser"));
    }

    @Test
    public void testValidarUsuario_Valide_Administrador() {
        assertTrue(Usuario.validarUsuario("administrador"));
    }

    @Test
    public void testValidarUsuario_Invalide_Separateur() {
        assertFalse(Usuario.validarUsuario("test;User"));
    }

    @Test
    public void testValidarPassword_Valide() {
        assertTrue(Usuario.validarPassword("_testUser", "pass123"));
    }

    @Test
    public void testValidarPassword_Invalide_Vide() {
        assertFalse(Usuario.validarPassword("_testUser", ""));
    }

    @Test
    public void testValidarPassword_Invalide_Espaces() {
        assertFalse(Usuario.validarPassword("_testUser", "pass 123"));
    }

    @Test
    public void testValidarPassword_Invalide_AdministradorMotDePasseAdmin() {
        assertFalse(Usuario.validarPassword("administrador", "admin"));
    }

    @Test
    public void testValidarPassword_Invalide_TropCourt() {
        assertFalse(Usuario.validarPassword("_testUser", "pas"));
    }

    @Test
    public void testValidarPassword_Invalide_IdentiqueUtilisateur() {
        assertFalse(Usuario.validarPassword("_testUser", "_testUser"));
    }

    @Test
    public void testValidarPassword_Invalide_Separateur() {
        assertFalse(Usuario.validarPassword("_testUser", "pass;123"));
    }
}