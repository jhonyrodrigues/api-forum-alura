package br.com.alura.forum.mapper

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.TopicResponse
import br.com.alura.forum.gateway.database.model.TopicDatabase
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper : Mapper<TopicDomain, TopicResponse> {
    override fun map(t: TopicDomain): TopicResponse {
        return TopicResponse(
                id = t.id,
                title = t.title,
                message = t.message,
                createdAt = t.createdAt,
                status = t.status
        )
    }
}