package br.com.zup.edu.kasadocodigo.kasadocodigo.autores

import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.management.loading.ClassLoaderRepository
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import kotlin.math.max

@RestController
@RequestMapping("/api/autores")
class AutorController(val autorRepository: AutorRepository) {

    @PostMapping
    fun cadastra(@RequestBody @Valid request: NovoAutorRequest) = request.paraAutor()
        .let(autorRepository::save)
        .let {
        ResponseEntity.ok().build<Any>()
    }


    @InitBinder("novoAutorRequest")
    fun binder(binder: WebDataBinder){
        binder.addValidators(CampoUnicoValidator(autorRepository))
    }

    class CampoUnicoValidator(val autorRepository: AutorRepository) : Validator {

        override fun supports(clazz: Class<*>): Boolean {
            return clazz.isAssignableFrom(NovoAutorRequest::class.java)
        }

        override fun validate(target: Any, errors: Errors) {
            val autor = target as NovoAutorRequest

            if (autorRepository.existsByEmail(autor.email!!)){
                errors.rejectValue("email", "email.jaCadastrado", "Email já Cadastrado")
            }
        }

    }


}


