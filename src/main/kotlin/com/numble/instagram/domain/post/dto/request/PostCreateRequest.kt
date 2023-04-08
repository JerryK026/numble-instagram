package com.numble.instagram.domain.post.dto.request

import com.numble.instagram.domain.post.domain.Post

data class PostCreateRequest(
    val content: String,
    val imageUrl: String,
) {
    fun toEntity(): Post {
        return Post(content, imageUrl)
    }
}