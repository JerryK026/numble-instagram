package com.numble.instagram.domain.member.entity

import com.numble.instagram.global.entity.BaseEntity
import jakarta.persistence.*

@Entity
class Follower(
    @ManyToOne
    val member: Member,

    @ManyToOne
    val follower: Member,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?= null,
) : BaseEntity()