package br.com.alura.forum.domain

import java.time.LocalDateTime

data class TopicDomain(
        val id: Long? = null,
        val title: String,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: Author,
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
        val answers: List<Answer> = ArrayList()
)