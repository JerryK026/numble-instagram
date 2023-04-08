package com.numble.instagram.domain.post.domain

import com.numble.instagram.domain.member.entity.Member
import com.numble.instagram.global.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Post(
    val content: String,

    val imageUrl: String,

    /* TODO: 잠시 봉인해둔 뒤 JWT 구현 후 추가 구현
    @ManyToOne
    val member: Member,

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity()