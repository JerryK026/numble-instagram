package com.numble.instagram.domain.like.entity

import com.numble.instagram.domain.post.domain.Post
import com.numble.instagram.global.entity.BaseEntity
import jakarta.persistence.*

@Entity
class Likes(
    @ManyToOne
    val post: Post,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
) : BaseEntity()