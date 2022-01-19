package br.com.alura.forum.domain.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class AuthorRequest(
        @field:NotBlank val name: String,
        @field:Email @field:NotBlank val email: String,
)
