package br.com.zup.edu.kasadocodigo.kasadocodigo.categoria

import javax.validation.constraints.NotBlank

data class NovaCategoriaRequest (@field:NotBlank val nome: String?,

                            ) {
    fun paraCategoria() = Categoria(nome!!)

}
