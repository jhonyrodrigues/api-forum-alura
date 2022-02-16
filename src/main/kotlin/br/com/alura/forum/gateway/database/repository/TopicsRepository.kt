package br.com.alura.forum.gateway.database.repository

import br.com.alura.forum.gateway.database.model.TopicDatabase
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicsRepository : JpaRepository<TopicDatabase, Long> {
    fun findByCourseName(nameCourse: String, pageable: Pageable): Page<TopicDatabase>
}