package br.com.alura.forum.gateway

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicGateway {
    fun create(topic: TopicDomain): TopicDomain

    fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicDomain

    fun findById(id: Long): TopicDomain

    fun findAll(pageable: Pageable): Page<TopicDomain>

    fun delete(id: Long)

    fun findByNameCourse(nameCourse: String, pageable: Pageable): Page<TopicDomain>
}