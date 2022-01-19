package br.com.alura.forum.domain

data class Author(
        var id: Long? = null,
        val name: String,
        val email: String,
)
