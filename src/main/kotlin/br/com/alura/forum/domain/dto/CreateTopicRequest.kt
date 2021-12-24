package br.com.alura.forum.domain.dto

data class CreateTopicRequest(
        val title: String,
        val message: String,
        val courseId: Long,
        val authorId: Long
)