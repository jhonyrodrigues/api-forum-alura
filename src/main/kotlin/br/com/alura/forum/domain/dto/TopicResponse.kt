package br.com.alura.forum.domain.dto

import br.com.alura.forum.domain.StatusTopic
import java.time.LocalDateTime

data class TopicResponse(
        val id: Long?,
        val title: String,
        val message: String,
        val status: StatusTopic,
        val createdAt: LocalDateTime
)