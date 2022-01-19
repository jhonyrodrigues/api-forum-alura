package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.CourseRequest
import br.com.alura.forum.domain.dto.CourseResponse
import br.com.alura.forum.useCase.CourseUseCase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CourseController(private val courseUseCase: CourseUseCase) : CourseApi {
    override fun create(courseRequest: CourseRequest): ResponseEntity<CourseResponse> {
        val response = courseUseCase.execute(courseRequest)
        return ResponseEntity.status(CREATED).body(response)
    }
}