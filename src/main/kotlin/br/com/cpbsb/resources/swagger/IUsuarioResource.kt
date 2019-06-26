package br.com.cpbsb.resources.swagger

import br.com.cpbsb.DTO.UsuarioDTO
import io.swagger.annotations.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Api(value = "usuarios", description = "Operações relacionadas a Usuários")
interface IUsuarioResource {

    @ApiOperation(value = "Salvar novo usuárior", response = UsuarioDTO::class, nickname = "salvarUsuario", tags = arrayOf("usuarios"),
            authorizations = arrayOf(Authorization("bearerAuth")))
    @ApiResponses(
            value = *arrayOf(
                    ApiResponse(code = 201, message = "Usuário criado com sucesso"),
                    ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
                    ApiResponse(code = 403, message = "Não autorizado")
            )
    )
    fun salvar(@RequestBody usuario: UsuarioDTO): ResponseEntity<UsuarioDTO>

    @ApiOperation(value = "Consuktar usuário autenticado", response = UsuarioDTO::class, nickname = "consultarUsuario", tags = arrayOf("usuarios"),
            authorizations = arrayOf(Authorization("bearerAuth")))
    @ApiResponses(
            value = *arrayOf(
                    ApiResponse(code = 200, message = "Usuário recuperado com sucesso"),
                    ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
                    ApiResponse(code = 403, message = "Não autorizado"),
                    ApiResponse(code = 404, message = "Usuário não encontrada")
            )
    )
    fun consuiltar(): ResponseEntity<String>
}