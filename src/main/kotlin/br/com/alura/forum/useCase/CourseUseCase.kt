package br.com.alura.forum.useCase

import br.com.alura.forum.domain.Course
import br.com.alura.forum.domain.dto.CourseRequest
import br.com.alura.forum.domain.dto.CourseResponse
import br.com.alura.forum.gateway.CourseGateway
import br.com.alura.forum.gateway.exception.NotFoundException
import br.com.alura.forum.mapper.CourseRequestMapper
import br.com.alura.forum.mapper.CourseResponseMapper
import org.springframework.stereotype.Component

@Component
class CourseUseCase(
        private val courseGateway: CourseGateway,
        private val courseRequestMapper: CourseRequestMapper,
        private val courseResponseMapper: CourseResponseMapper,
) {

    fun execute(request: CourseRequest): CourseResponse {
        val course = courseRequestMapper.map(request)

        val courseDatabase = courseGateway.execute(course)

        return courseResponseMapper.map(courseDatabase)
    }

    fun findById(id: Long): Course {
        try {
            return courseGateway.findById(id)
        } catch (e: Exception) {
            throw NotFoundException("Course Not found")
        }
    }
}