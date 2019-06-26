package br.com.cpbsb.models;

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Usando o padrão kotlin onde o retorno é explicito (jeito kotlin de fazer mais do mesmo
 * de maneira diferente)
 */
class UserDetailsImpl(private val user: Usuario) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf()

    override fun isEnabled() = true

    override fun getUsername(): String = user.email

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = user.senha

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

}