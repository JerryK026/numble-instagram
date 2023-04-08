package com.numble.instagram.domain.comment.entity

import com.numble.instagram.domain.post.entity.Post
import jakarta.persistence.*

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,

    val content: String,

    @ManyToOne
    val post: Post,

    @ManyToOne
    val parentComment: Comment,
)