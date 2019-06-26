package br.com.cpbsb.models

import br.com.cpbsb.DTO.UsuarioDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Usuario (

        @Id
        @SequenceGenerator(name = "GENERATOR_USUARIO", sequenceName = "USU_SEQ")
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_USUARIO")
        @Column(name = "ID", nullable = false, unique = true)
        @JsonIgnore
        var id: Long,

        @Column(name = "NOME")
        var nome: String,

        @Column(name = "EMAIL")
        var email: String,

        @Column(name = "SENHA")
        var senha: String,

        @ManyToOne
        @JoinColumn(name = "usuarioTipo", referencedColumnName = "id", nullable = true)
        var usuarioTipo: UsuarioTipo
)

fun Usuario.toUsuarioDTO() = UsuarioDTO(
        nome = nome,
        email = email,
        senha = senha,
        usuarioTipo = usuarioTipo.id
)

