package br.com.alura.forum.useCase

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import br.com.alura.forum.mapper.TopicRequestMapper
import br.com.alura.forum.mapper.TopicResponseMapper
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class TopicsUseCase(
        private var topics: List<TopicDomain> = ArrayList(),
        private val topicoViewMapper: TopicResponseMapper,
        private val topicoFormMapper: TopicRequestMapper,
) {

    fun list(): List<TopicResponse> {
        return topics.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicResponse {
        val topico = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicoViewMapper.map(topico)
    }

    fun create(request: CreateTopicRequest): TopicResponse {
        val topico = topicoFormMapper.map(request)
        topico.id = topics.size.toLong() + 1
        topics = topics.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicResponse {
        val topico = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        topico.title = updateTopicRequest.title
        topico.message = updateTopicRequest.message

        return topicoViewMapper.map(topico)
    }

    fun delete(id: Long) {
        val topico = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        topics = topics.minus(topico)
    }
}