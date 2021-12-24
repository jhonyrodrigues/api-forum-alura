package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.useCase.TopicsUseCase
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicsController(private val topicsUseCase: TopicsUseCase) : TopicsApi {

    override fun list(): List<TopicResponse> {

        return topicsUseCase.list()
    }

    override fun findById(id: Long): TopicResponse {

        return topicsUseCase.findById(id)
    }

    override fun create(createTopicRequest: CreateTopicRequest) {
        topicsUseCase.create(createTopicRequest)
    }
}