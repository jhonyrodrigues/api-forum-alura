package br.com.alura.forum.gateway

import br.com.alura.forum.domain.Course

interface CourseGateway {
    fun execute(course: Course): Course
    fun findById(id: Long): Course
}
