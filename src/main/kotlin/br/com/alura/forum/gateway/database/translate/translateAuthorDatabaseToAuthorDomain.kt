package br.com.alura.forum.gateway.database.translate

import br.com.alura.forum.domain.Author
import br.com.alura.forum.gateway.database.model.AuthorDatabase

fun translateAuthorDatabaseToAuthorDomain(authorDatabase: AuthorDatabase) =
        Author(authorDatabase.id, authorDatabase.name, authorDatabase.email)