package br.com.alura.forum.gateway.database.repository

import br.com.alura.forum.gateway.database.model.AuthorDatabase
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<AuthorDatabase, Long>