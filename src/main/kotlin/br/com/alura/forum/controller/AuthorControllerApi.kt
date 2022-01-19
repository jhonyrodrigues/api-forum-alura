package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.AuthorRequest
import br.com.alura.forum.domain.dto.AuthorResponse
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/author")
interface AuthorControllerApi {
    @PostMapping()
    @Transactional
    fun create(@RequestBody @Valid authorRequest: AuthorRequest): ResponseEntity<AuthorResponse>
}