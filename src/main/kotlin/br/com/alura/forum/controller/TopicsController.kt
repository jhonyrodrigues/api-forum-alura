package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicPerCategoryDto
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import br.com.alura.forum.useCase.TopicsUseCase
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
class TopicsController(private val topicsUseCase: TopicsUseCase) : TopicsApi {

    override fun list(nameCourse: String?,
    pageable: Pageable): Page<TopicResponse> {

        return topicsUseCase.list(nameCourse, pageable)
    }

    override fun findById(id: Long): TopicResponse {

        return topicsUseCase.findById(id)
    }

    override fun create(
            createTopicRequest: CreateTopicRequest,
    ): ResponseEntity<TopicResponse> {

        val response = topicsUseCase.create(createTopicRequest)

        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/topics/${response.id}").build().toUri()

        return ResponseEntity.created(uri).body(response)
    }

    override fun update(id: Long, updateTopicRequest: UpdateTopicRequest): ResponseEntity<TopicResponse> {

        val response = topicsUseCase.update(id, updateTopicRequest)

        return ResponseEntity.ok(response)
    }

    override fun delete(id: Long) {

        topicsUseCase.delete(id)
    }

    override fun relatorio(): List<TopicPerCategoryDto> {
       return topicsUseCase.report()
    }
}