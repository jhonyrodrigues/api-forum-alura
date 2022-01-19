package br.com.alura.forum.gateway.database

import br.com.alura.forum.domain.Author
import br.com.alura.forum.gateway.AuthorGateway
import br.com.alura.forum.gateway.database.repository.AuthorRepository
import br.com.alura.forum.gateway.database.translate.translateAuthorDatabaseToAuthorDomain
import br.com.alura.forum.gateway.database.translate.translateAuthorDomainToAuthorDatabase
import org.springframework.stereotype.Component

@Component
class AuthorGatewayImpl(
        private val authorRepository: AuthorRepository,
) : AuthorGateway {
    override fun execute(author: Author): Author {

        val author = translateAuthorDomainToAuthorDatabase(author)

        val authorDatabase = authorRepository.save(author)

        return translateAuthorDatabaseToAuthorDomain(authorDatabase)
    }

    override fun findById(id: Long): Author {

        val authorDatabase = authorRepository.findById(id)

        return translateAuthorDatabaseToAuthorDomain(authorDatabase.get())
    }
}