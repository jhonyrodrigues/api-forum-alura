package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
interface TopicsApi {

    @GetMapping
    @Cacheable("topics")
    fun list(): List<TopicResponse>

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicResponse

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun create(@RequestBody @Valid createTopicRequest: CreateTopicRequest): ResponseEntity<TopicResponse>

    @PutMapping("{id}")
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@PathVariable id: Long, @RequestBody @Valid updateTopicRequest: UpdateTopicRequest): ResponseEntity<TopicResponse>

    @DeleteMapping("{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["topics"], allEntries = true)
    fun delete(@PathVariable id: Long)
}