package br.com.alura.forum.useCase

import br.com.alura.forum.domain.Author
import br.com.alura.forum.domain.dto.AuthorRequest
import br.com.alura.forum.domain.dto.AuthorResponse
import br.com.alura.forum.gateway.AuthorGateway
import br.com.alura.forum.gateway.exception.NotFoundException
import br.com.alura.forum.mapper.AuthorRequestMapper
import br.com.alura.forum.mapper.AuthorResponseMapper
import org.springframework.stereotype.Component

@Component
class AuthorUseCase(
        private val authorGateway: AuthorGateway,
        private val authorRequestMapper: AuthorRequestMapper,
        private val authorResponseMapper: AuthorResponseMapper,
) {
    fun execute(request: AuthorRequest): AuthorResponse {
        val author = authorRequestMapper.map(request)

        val authorDatabase = authorGateway.execute(author)

        return authorResponseMapper.map(authorDatabase)
    }

    fun findById(id: Long): Author {
        try {
            return authorGateway.findById(id)
        } catch (e: Exception) {
            throw NotFoundException("Author Not found")
        }
    }
}