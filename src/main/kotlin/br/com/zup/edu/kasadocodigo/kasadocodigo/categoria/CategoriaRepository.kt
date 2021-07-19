package br.com.zup.edu.kasadocodigo.kasadocodigo.categoria

import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository : JpaRepository<Categoria, Long> {
}