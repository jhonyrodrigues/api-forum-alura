package br.com.alura.forum.useCase

import br.com.alura.forum.domain.Author
import org.springframework.stereotype.Component

@Component
class AuthorUseCase(var authors: List<Author> = ArrayList()) {
    init {
        val author = Author(
                id = 1,
                name = "Jhony Rodrigues",
                email = "jhony@email.com.br"
        )
        authors = listOf(author)
    }

    fun buscarPorId(id: Long): Author {
        return authors.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}