package br.com.alura.forum.useCase

import br.com.alura.forum.domain.Course
import org.springframework.stereotype.Component

@Component
class CourseUseCase(var courses: List<Course> = ArrayList()) {
    init {
        val course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
        )
        courses = listOf(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}