package service

import kotlinx.coroutines.delay
import model.*

object AuthService {
    suspend fun autenticarUsuario(usuario: String, contrasena: String): ResultadoLogin {
        delay(2000L) // Simula tiempo de espera de red
        return if (usuario == "admin" && contrasena == "1234") {
            ResultadoLogin.Exito(PerfilUsuario("Administrador", "admin@duocuc.cl"))
        } else {
            ResultadoLogin.Error("Credenciales incorrectas")
        }
    }
}