package br.com.alura.forum.gateway

import br.com.alura.forum.domain.Author

interface AuthorGateway {
    fun execute(author: Author): Author
    fun findById(id: Long): Author
}
