package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import br.com.alura.forum.useCase.TopicsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
class TopicsController(private val topicsUseCase: TopicsUseCase) : TopicsApi {

    override fun list(): List<TopicResponse> {

        return topicsUseCase.list()
    }

    override fun findById(id: Long): TopicResponse {

        return topicsUseCase.findById(id)
    }

    override fun create(
            createTopicRequest: CreateTopicRequest,
            uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<TopicResponse> {

        val response = topicsUseCase.create(createTopicRequest)

        val uri = uriComponentsBuilder.path("/topics/${response.id}").build().toUri()

        return ResponseEntity.created(uri).body(response)
    }

    override fun update(@PathVariable id: Long, @RequestBody @Valid updateTopicRequest: UpdateTopicRequest): ResponseEntity<TopicResponse> {

        val response = topicsUseCase.update(id, updateTopicRequest)

        return ResponseEntity.ok(response)
    }

    override fun delete(@PathVariable id: Long) {

        topicsUseCase.delete(id)
    }
}