package br.com.zup.edu.kasadocodigo.kasadocodigo.categoria

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/categorias")
class CategoriaController (val categoriaRepository: CategoriaRepository) {

    @PostMapping
    fun cadastraCategoria (@RequestBody @Valid request : NovaCategoriaRequest) = request.paraCategoria()
        .let (categoriaRepository::save)
        .let {
            ResponseEntity.ok().build<Any>()
        }
}