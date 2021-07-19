package br.com.zup.edu.kasadocodigo.kasadocodigo.compartilhado

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(ex: MethodArgumentNotValidException) : ResponseEntity<Any> {

        val erros = mutableListOf<Map<String, String?>>()

        for(fieldError in ex.fieldErrors){
            erros.add(mapOf(Pair(fieldError.field, fieldError.defaultMessage)))
        }
        return ResponseEntity.badRequest().body(erros)
    }
}