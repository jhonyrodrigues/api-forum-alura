package br.com.alura.forum.gateway.database.translate

import br.com.alura.forum.domain.Answer
import br.com.alura.forum.domain.Author
import br.com.alura.forum.domain.Course
import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.gateway.database.model.TopicDatabase

fun translateTopicDatabaseToTopicDomain(topic: TopicDatabase) =
        TopicDomain(
                id = topic.id,
                title = topic.title,
                message = topic.message,
                createdAt = topic.createdAt,
                course = Course(
                        topic.course.id,
                        topic.course!!.name,
                        topic.course.category
                ),
                author = Author(
                        name = topic.author!!.name!!,
                        email = topic.author.email
                ),
                status = topic.status,
                answers = topic.answers.map {
                    Answer(
                            id = it.id!!,
                            message = it.message,
                            createdAt = it.createdAt,
                            author = Author(
                                    name = it.author.name,
                                    email = it.author.email),
                            statusTopic = it.topic!!.status,
                            solution = it.solution)
                }
        )