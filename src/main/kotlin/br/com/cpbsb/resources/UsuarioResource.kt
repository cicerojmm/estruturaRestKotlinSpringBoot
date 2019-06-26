package br.com.cpbsb.resources

import br.com.cpbsb.DTO.UsuarioDTO
import br.com.cpbsb.resources.swagger.IUsuarioResource
import br.com.cpbsb.services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/usuarios")
class UsuarioResource : IUsuarioResource {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @PostMapping
    override fun salvar(@RequestBody usuario: UsuarioDTO): ResponseEntity<UsuarioDTO> {
        val usuarioCriado = usuarioService.salvarUsuario(usuario)
        return ResponseEntity.created(URI("")).body(usuarioCriado)
    }

    @GetMapping("/autenticado")
    override fun consuiltar(): ResponseEntity<String> = ResponseEntity.ok(usuarioService.consultar()!!)

}