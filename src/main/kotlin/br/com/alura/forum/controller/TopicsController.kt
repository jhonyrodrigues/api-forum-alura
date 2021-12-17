package br.com.alura.forum.controller

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.useCase.GetTopicsUseCase
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicsController(private val getTopicsUseCase: GetTopicsUseCase) : TopicsApi {

    override fun list(): List<TopicDomain> {

        return getTopicsUseCase.list()
    }

    override fun findById(id: Long): TopicDomain {

        return getTopicsUseCase.findById(id)
    }
}