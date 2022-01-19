package br.com.alura.forum.gateway.database.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class AnswerDatabase(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val author: AuthorDatabase,
        @ManyToOne()
        val topic: TopicDatabase,
        val solution: Boolean,
)
