
import kotlinx.coroutines.runBlocking
import model.*
import service.AuthService

fun main() = runBlocking {
    println("Estado actual: ${ResultadoLogin.Autenticando}")

    val resultado1 = AuthService.autenticarUsuario("admin", "1234")
    manejarResultado(resultado1)

    val resultado2 = AuthService.autenticarUsuario("usuario", "0000")
    manejarResultado(ResultadoLogin.Autenticando)
    manejarResultado(resultado2)
}

fun manejarResultado(resultado: ResultadoLogin) {

    when (resultado) {
        /*is ResultadoLogin.Exito -> {
            println("Login exitoso")
            println("Usuario: ${resultado.perfil.nombreUsuario}")
            println("Email: ${resultado.perfil.email}")
        }*/

        is ResultadoLogin.Exito -> resultado.perfil.let { perfil ->
            println("Login exitoso")
            println("Usuario: ${perfil.nombreUsuario}")
            println("Email: ${perfil.email}")
        }

        is ResultadoLogin.Error -> println("Error: ${resultado.mensaje}")
        ResultadoLogin.Autenticando -> println("Autenticando...")
    }
}