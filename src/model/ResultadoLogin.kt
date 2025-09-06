package model

sealed class ResultadoLogin {
    data class Exito(val perfil: PerfilUsuario) : ResultadoLogin()
    data class Error(val mensaje: String) : ResultadoLogin()
    object Autenticando : ResultadoLogin() {
        override fun toString(): String = "Autenticando..."
    }
}