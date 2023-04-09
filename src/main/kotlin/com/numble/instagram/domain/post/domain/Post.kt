package com.numble.instagram.domain.post.domain

import com.numble.instagram.domain.member.entity.Member
import com.numble.instagram.global.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Post(
    var content: String,

    @Column(nullable = true)
    var imageUrl: String?,

    /* TODO: 잠시 봉인해둔 뒤 JWT 구현 후 추가 구현
    @ManyToOne
    val member: Member,

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity() {

    fun update(content: String?, imageUrl: String?) {
        if (content != null) {
            this.content = content
        }
        if (imageUrl != null) {
            this.imageUrl = imageUrl
        }
    }
}