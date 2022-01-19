package br.com.alura.forum.gateway.database.translate

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.gateway.database.model.AnswerDatabase
import br.com.alura.forum.gateway.database.model.AuthorDatabase
import br.com.alura.forum.gateway.database.model.CourseDatabase
import br.com.alura.forum.gateway.database.model.TopicDatabase
import java.time.LocalDateTime
import java.util.stream.Collectors

fun translateTopicDomainToTopicDatabase(topic: TopicDomain) =
        TopicDatabase(
                title = topic.title,
                message = topic.message,
                createdAt = topic.createdAt,
                course = CourseDatabase(
                        topic.course!!.name,
                        topic.course.category
                ),
                author = AuthorDatabase(
                        name = topic.author!!.name!!,
                        email = topic.author.email
                ),
                status = topic.status,
                answers = topic.answers.stream().map {
                    AnswerDatabase(
                            id = it.id!!,
                            message = it.message,
                            createdAt = it.createdAt,
                            author = AuthorDatabase(
                                    name = it.author.name,
                                    email = it.author.email),
                            topic = TopicDatabase(
                                    title = topic.title,
                                    message = topic.message,
                                    createdAt = LocalDateTime.now(),
                                    course = CourseDatabase(
                                            name = topic.course.name,
                                            category = topic.course.category
                                    ),
                                    author = AuthorDatabase(
                                            name = it.author.name,
                                            email = it.author.email),

                                    status = topic.status),
                            solution = it.solution)
                }.collect(Collectors.toList()))