package br.com.alura.forum.domain

import java.time.LocalDateTime

data class TopicDomain(
        var id: Long? = null,
        var title: String,
        var message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val course: Course?,
        val author: Author,
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
        val answers: List<Answer> = ArrayList(),
)