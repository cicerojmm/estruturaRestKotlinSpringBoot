package br.com.cpbsb.repository

import br.com.cpbsb.models.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long>{

    fun findByEmail(email: String?): Usuario?
}