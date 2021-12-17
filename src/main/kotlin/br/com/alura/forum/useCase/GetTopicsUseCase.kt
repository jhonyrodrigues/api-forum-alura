package br.com.alura.forum.useCase

import br.com.alura.forum.domain.Author
import br.com.alura.forum.domain.Course
import br.com.alura.forum.domain.TopicDomain
import org.springframework.stereotype.Component

@Component
class GetTopicsUseCase(private var topics: List<TopicDomain>) {

    init {
        val topic1 = TopicDomain(
                id = 1,
                title = "Dúvidas em Kotlin",
                message = "Variáveis no Kotlin",
                course = Course(
                        id = 1,
                        name = "Kotlin",
                        category = "Programação"),
                author = Author(
                        id = 1,
                        name = "Jhony Rodrigues",
                        email = "jhony@author.com"))
        val topic2 = TopicDomain(
                id = 2,
                title = "Dúvidas em Java",
                message = "Variáveis no Java",
                course = Course(
                        id = 2,
                        name = "Java",
                        category = "Programação"),
                author = Author(
                        id = 1,
                        name = "Jhony Rodrigues",
                        email = "jhony@author.com"))
        val topic3 = TopicDomain(
                id = 3,
                title = "Dúvidas em Spring",
                message = "API Rest com Spring Boot",
                course = Course(
                        id = 3,
                        name = "Spring",
                        category = "Framework"),
                author = Author(
                        id = 1,
                        name = "Jhony Rodrigues",
                        email = "jhony@author.com"))

        topics = arrayListOf(topic1, topic2, topic3)
    }

    fun list(): List<TopicDomain> {
        return createTopics()
    }

    fun createTopics(): List<TopicDomain> {
        return topics
    }

    fun findById(id: Long): TopicDomain {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}