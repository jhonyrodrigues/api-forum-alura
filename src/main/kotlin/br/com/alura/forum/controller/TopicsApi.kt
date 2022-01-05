package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
interface TopicsApi {

    @GetMapping
    fun list(): List<TopicResponse>

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicResponse

    @PostMapping()
    fun create(@RequestBody createTopicRequest: CreateTopicRequest, uri: UriComponentsBuilder): ResponseEntity<TopicResponse>

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid updateTopicRequest: UpdateTopicRequest): ResponseEntity<TopicResponse>

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long)
}