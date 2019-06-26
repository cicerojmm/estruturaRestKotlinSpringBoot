package br.com.cpbsb.services

import br.com.cpbsb.DTO.UsuarioDTO
import br.com.cpbsb.DTO.toUsuario
import br.com.cpbsb.models.UserDetailsImpl
import br.com.cpbsb.models.UsuarioTipo
import br.com.cpbsb.models.toUsuarioDTO
import br.com.cpbsb.repository.UsuarioRepository
import br.com.cpbsb.repository.UsuarioTipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired
    lateinit var usuarioRespository: UsuarioRepository

    @Autowired
    lateinit var usuarioTipoRepository: UsuarioTipoRepository

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder


    fun salvarUsuario(usuarioDTO: UsuarioDTO): UsuarioDTO {

        var usuarioTipo: UsuarioTipo? = null

        usuarioTipoRepository.findById(usuarioDTO.usuarioTipo).map { usuarioTipoRetorno ->
            usuarioTipo = usuarioTipoRetorno
        }


        usuarioDTO.senha = bCryptPasswordEncoder.encode(usuarioDTO.senha)
        var usuario = usuarioDTO.toUsuario(usuarioTipo!!)


        return usuarioRespository.save(usuario).toUsuarioDTO()
    }


    fun consultar(): String? = usuarioRespository.findByEmail(getCurrentUserEmail())?.nome

    private fun getCurrentUserEmail(): String? {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetailsImpl
        return user.username
    }

}