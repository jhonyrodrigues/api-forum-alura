package br.com.alura.forum.gateway.database

import br.com.alura.forum.domain.TopicDomain
import br.com.alura.forum.domain.dto.TopicPerCategoryDto
import br.com.alura.forum.domain.dto.UpdateTopicRequest
import br.com.alura.forum.gateway.TopicGateway
import br.com.alura.forum.gateway.database.repository.TopicsRepository
import br.com.alura.forum.gateway.database.translate.translateTopicDatabaseToTopicDomain
import br.com.alura.forum.gateway.database.translate.translateTopicDomainToTopicDatabase
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class TopicGatewayImpl(
        private val repository: TopicsRepository,
) : TopicGateway {
    override fun create(topicDomain: TopicDomain): TopicDomain {

        val topicDatabase = repository.save(translateTopicDomainToTopicDatabase(topicDomain))

        return translateTopicDatabaseToTopicDomain(topicDatabase)
    }

    override fun update(id: Long, updateTopicRequest: UpdateTopicRequest): TopicDomain {

        val topicDatabase = repository.findById(id).get()

        topicDatabase.title = updateTopicRequest.title

        topicDatabase.message = updateTopicRequest.message

        return translateTopicDatabaseToTopicDomain(topicDatabase)
    }

    override fun findById(id: Long): TopicDomain {
        val topicDatabase = repository.findById(id)
        return translateTopicDatabaseToTopicDomain(topicDatabase.get())
    }

    override fun findAll(pageable: Pageable): Page<TopicDomain> {
        return repository.findAll(pageable).map { topic ->
            translateTopicDatabaseToTopicDomain(topic)
        }
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    override fun findByNameCourse(nameCourse: String, pageable: Pageable): Page<TopicDomain> {
        return repository.findByCourseName(nameCourse, pageable).map { topic ->
            translateTopicDatabaseToTopicDomain(topic)
        }
    }

    override fun report(): List<TopicPerCategoryDto> {
        return repository.report()
    }
}