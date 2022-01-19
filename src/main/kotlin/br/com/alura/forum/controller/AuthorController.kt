package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.AuthorRequest
import br.com.alura.forum.domain.dto.AuthorResponse
import br.com.alura.forum.useCase.AuthorUseCase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(private val authorUseCase: AuthorUseCase) : AuthorControllerApi {
    override fun create(authorRequest: AuthorRequest): ResponseEntity<AuthorResponse> {
        val response = authorUseCase.execute(authorRequest)
        return ResponseEntity.status(CREATED).body(response)
    }
}