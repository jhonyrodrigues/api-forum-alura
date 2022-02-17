package br.com.alura.forum.useCase

import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicPerCategoryDto
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import br.com.alura.forum.gateway.TopicGateway
import br.com.alura.forum.gateway.exception.NotFoundException
import br.com.alura.forum.mapper.TopicRequestMapper
import br.com.alura.forum.mapper.TopicResponseMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

private const val ID_NOT_FOUND = "Id not found"

@Component
class TopicsUseCase(
        private val topicGateway: TopicGateway,
        private val topicRequestMapper: TopicRequestMapper,
        private val topicResponseMapper: TopicResponseMapper,
) {

    fun list(
            nameCourse: String?,
            pageable: Pageable,
    ): Page<TopicResponse> {
        val topics = if (nameCourse == null) {
            topicGateway.findAll(pageable)
        } else {
            topicGateway.findByNameCourse(nameCourse, pageable)
        }
        return topics.map { t ->
            topicResponseMapper.map(t)
        }
    }


    fun findById(id: Long): TopicResponse {
        try {
            val topic = topicGateway.findById(id)

            return topicResponseMapper.map(topic)

        } catch (e: Exception) {
            throw NotFoundException(ID_NOT_FOUND)
        }
    }

    fun create(request: CreateTopicRequest): TopicResponse {

        val topic = topicRequestMapper.map(request)

        val topicDatabase = topicGateway.create(topic)

        return topicResponseMapper.map(topicDatabase)
    }

    fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicResponse {
        try {
            val topic = topicGateway.update(id, updateTopicRequest)

            return topicResponseMapper.map(topic)

        } catch (e: Exception) {
            throw NotFoundException(ID_NOT_FOUND)
        }
    }

    fun delete(id: Long) {
        try {
            val topic = topicGateway.findById(id)

            topicGateway.delete(topic.id!!)

        } catch (e: Exception) {
            throw NotFoundException(ID_NOT_FOUND)
        }
    }

    fun report(): List<TopicPerCategoryDto> {
        return topicGateway.report()
    }
}