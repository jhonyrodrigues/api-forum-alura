package br.com.alura.forum.domain

import java.time.LocalDateTime

data class Answer(
        val id: Long? = null,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val author: Author,
        val statusTopic: StatusTopic,
        val solution: Boolean,
)
