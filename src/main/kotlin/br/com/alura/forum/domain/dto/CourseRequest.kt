package br.com.alura.forum.domain.dto

import javax.validation.constraints.NotBlank

data class CourseRequest(
        @field:NotBlank val name: String,
        @field:NotBlank val category: String
)
