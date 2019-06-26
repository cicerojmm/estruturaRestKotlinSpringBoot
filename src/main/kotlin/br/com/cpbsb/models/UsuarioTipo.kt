package br.com.cpbsb.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class UsuarioTipo(

    @Id
    @SequenceGenerator(name = "GENERATOR_USUT", sequenceName = "USUT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_USUT")
    @Column(name = "ID", nullable = false, unique = true)
    @JsonIgnore
    val id: Long,

    @Column(name = "DESCRICAO")
    val descricao: String

)