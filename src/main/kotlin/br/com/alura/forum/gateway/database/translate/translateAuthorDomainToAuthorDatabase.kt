package br.com.alura.forum.gateway.database.translate

import br.com.alura.forum.domain.Author
import br.com.alura.forum.gateway.database.model.AuthorDatabase

fun translateAuthorDomainToAuthorDatabase(author: Author) = AuthorDatabase(
        name = author.name,
        email = author.email
)