package br.com.alura.forum.gateway.database.repository

import br.com.alura.forum.gateway.database.model.CourseDatabase
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<CourseDatabase, Long>