package br.com.alura.forum.gateway.database

import br.com.alura.forum.domain.Course
import br.com.alura.forum.gateway.CourseGateway
import br.com.alura.forum.gateway.database.model.CourseDatabase
import br.com.alura.forum.gateway.database.repository.CourseRepository
import br.com.alura.forum.gateway.database.translate.translateCourseDatabaseToCourseDomain
import org.springframework.stereotype.Component

@Component
class CourseGatewayImpl(
        private val repository: CourseRepository,
) : CourseGateway {
    override fun execute(course: Course): Course {

        val course = CourseDatabase(course.name, course.category)

        val courseDatabase = repository.save(course)

        return Course(courseDatabase.id, courseDatabase.name, courseDatabase.category)
    }

    override fun findById(id: Long): Course {

        val courseDatabase = repository.findById(id)

        return translateCourseDatabaseToCourseDomain(courseDatabase.get())
    }
}