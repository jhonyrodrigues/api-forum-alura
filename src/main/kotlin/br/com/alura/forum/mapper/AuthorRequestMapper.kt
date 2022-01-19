package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Author
import br.com.alura.forum.domain.dto.AuthorRequest
import org.springframework.stereotype.Component

@Component
class AuthorRequestMapper : Mapper<AuthorRequest, Author> {
    override fun map(t: AuthorRequest): Author {
        return Author(
                name = t.name,
                email = t.email
        )
    }
}