package com.junu.book.domain.posts

import com.junu.book.domain.BaseTimeEntity
import com.junu.book.web.dto.PostsUpdateRequestDto
import javax.persistence.*

@Entity
class Posts(title: String, content: String, author: String) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set
    @Column(length = 500, nullable = false)
    var title: String = title
        protected set
    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String = content
        protected set
    var author: String = author
        protected set


    fun update(postsUpdateRequestDto: PostsUpdateRequestDto) {
        this.content = postsUpdateRequestDto.content
        this.title = postsUpdateRequestDto.title
    }
}
