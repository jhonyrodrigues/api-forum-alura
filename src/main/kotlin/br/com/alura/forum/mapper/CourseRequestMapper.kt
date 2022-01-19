package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Course
import br.com.alura.forum.domain.dto.CourseRequest
import org.springframework.stereotype.Component

@Component
class CourseRequestMapper : Mapper<CourseRequest, Course> {
    override fun map(t: CourseRequest): Course {
        return Course(
                name = t.name,
                category = t.category
        )
    }
}