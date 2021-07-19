package br.com.zup.edu.kasadocodigo.kasadocodigo.autores

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class NovoAutorRequest(@field:NotBlank val nome: String?,
                            @field:NotBlank @field:Email val email: String?,
                            @field:NotBlank @field:Size(max = 400) val descricao: String?,
) {
    fun paraAutor() = Autor (nome!!, email!!, descricao!!)

}