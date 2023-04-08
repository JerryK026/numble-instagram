package com.numble.instagram.domain.message.entity

import com.numble.instagram.domain.member.entity.Member
import com.numble.instagram.global.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class DirectMessage(
    val content: String,

    @ManyToOne
    val member: Member,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
) : BaseEntity()