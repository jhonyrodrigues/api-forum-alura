package br.com.alura.forum.gateway.database.model

import br.com.alura.forum.domain.StatusTopic
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TopicDatabase(
        var title: String,
        var message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        @Cascade(CascadeType.PERSIST)
        val course: CourseDatabase,
        @ManyToOne
        @Cascade(CascadeType.PERSIST)
        val author: AuthorDatabase,
        @Enumerated(value = EnumType.STRING)
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
        @OneToMany(mappedBy = "topic")
        val answers: List<AnswerDatabase> = ArrayList(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}