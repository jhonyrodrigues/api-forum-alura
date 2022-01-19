package br.com.alura.forum.gateway

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.UpdateTopicRequest

interface TopicGateway {
    fun create(topic: TopicDomain): TopicDomain

    fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicDomain

    fun findById(id: Long): TopicDomain

    fun findAll(): List<TopicDomain>

    fun delete(id: Long)
}