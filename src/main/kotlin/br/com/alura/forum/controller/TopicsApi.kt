package br.com.alura.forum.controller

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
interface TopicsApi {

    @GetMapping
    fun list(): List<TopicResponse>

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicResponse

    @PostMapping()
    fun create(@RequestBody createTopicRequest: CreateTopicRequest)
}