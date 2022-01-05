package br.com.alura.forum.domain.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateTopicRequest(
        @field:NotBlank val title: String,
        @field:NotBlank @field:Size(min = 5, max = 100) val message: String,
)
