package com.numble.instagram.domain.post.dao

import com.numble.instagram.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}