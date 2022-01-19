package br.com.alura.forum.gateway.database.translate

import br.com.alura.forum.domain.Course
import br.com.alura.forum.gateway.database.model.CourseDatabase

fun translateCourseDatabaseToCourseDomain(courseDatabase: CourseDatabase) =
        Course(
                courseDatabase.id,
                courseDatabase.name,
                courseDatabase.category
        )