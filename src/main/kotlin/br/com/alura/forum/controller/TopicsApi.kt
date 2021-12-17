package br.com.alura.forum.controller

import br.com.alura.forum.domain.TopicDomain
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
interface TopicsApi {

    @GetMapping
    fun list(): List<TopicDomain>

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicDomain
}