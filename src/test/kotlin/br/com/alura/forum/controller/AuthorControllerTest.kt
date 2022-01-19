package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.AuthorRequest
import br.com.alura.forum.domain.dto.AuthorResponse
import br.com.alura.forum.useCase.AuthorUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@ExtendWith(MockitoExtension::class)
internal class AuthorControllerTest() {

    //Injeção da classe que você vai testar
    @InjectMocks
    lateinit var authorController: AuthorController

    @Mock
    lateinit var authorUseCase: AuthorUseCase

    private lateinit var authorRequest: AuthorRequest

    private lateinit var authorResponse: AuthorResponse

    lateinit var responseEntity: ResponseEntity<AuthorResponse>

    @BeforeEach
    fun setup() {
        authorRequest = createAuthorRequest()
        authorResponse = authorResponse()
        responseEntity = responseEntity()
    }

    @Test
    fun createAuthor() {

        //cenário


        //ação

        `when`(authorUseCase.execute(authorRequest)).thenReturn(authorResponse)
        val controller = authorController.create(authorRequest)
        val response = authorUseCase.execute(authorRequest)

        //verificação

        assertNotNull(response)
        assertEquals(authorRequest.name, response.name)
        assertEquals(responseEntity, controller)

    }

    private fun createAuthorRequest() = AuthorRequest(
            "Stephanie Santos",
            "Stephanie@gmail.com"
    )

    private fun authorResponse() = AuthorResponse(
            0,
            "Stephanie Santos"
    )

    private fun responseEntity(): ResponseEntity<AuthorResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorResponse)
    }
}