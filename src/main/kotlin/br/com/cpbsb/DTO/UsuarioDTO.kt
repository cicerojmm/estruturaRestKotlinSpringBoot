package br.com.cpbsb.DTO

import br.com.cpbsb.models.Usuario
import br.com.cpbsb.models.UsuarioTipo

data class UsuarioDTO (

    val nome: String,

    val email: String,

    var senha: String,

    val usuarioTipo: Long
)

fun UsuarioDTO.toUsuario(tipo: UsuarioTipo) = Usuario(
        id = 0L,
        nome = nome,
        email = email,
        senha = senha,
        usuarioTipo = tipo
)