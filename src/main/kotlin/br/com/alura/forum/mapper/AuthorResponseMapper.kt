package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Author
import br.com.alura.forum.domain.dto.AuthorResponse
import org.springframework.stereotype.Component

@Component
class AuthorResponseMapper : Mapper<Author, AuthorResponse> {
    override fun map(t: Author): AuthorResponse {
        return AuthorResponse(
                id = t.id!!,
                name = t.name
        )
    }
}