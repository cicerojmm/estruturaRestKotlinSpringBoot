package br.com.cpbsb.repository

import br.com.cpbsb.models.UsuarioTipo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioTipoRepository : JpaRepository<UsuarioTipo, Long> {

}