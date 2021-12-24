package br.com.alura.forum.mapper

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.CreateTopicRequest
import br.com.alura.forum.useCase.AuthorUseCase
import br.com.alura.forum.useCase.CourseUseCase
import org.springframework.stereotype.Component

@Component
class TopicRequestMapper(
        private val courseUseCase: CourseUseCase,
        private val authorUseCase: AuthorUseCase,
) : Mapper<CreateTopicRequest, TopicDomain> {
    override fun map(t: CreateTopicRequest): TopicDomain {
        return TopicDomain(
                title = t.title,
                message = t.message,
                course = courseUseCase.findById(t.courseId),
                author = authorUseCase.buscarPorId(t.authorId)
        )
    }
}