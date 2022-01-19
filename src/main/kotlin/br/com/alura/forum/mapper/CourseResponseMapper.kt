package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Course
import br.com.alura.forum.domain.dto.CourseResponse
import org.springframework.stereotype.Component

@Component
class CourseResponseMapper : Mapper<Course, CourseResponse> {
    override fun map(t: Course): CourseResponse {
        return CourseResponse(
                id = t.id!!,
                name = t.name
        )
    }
}