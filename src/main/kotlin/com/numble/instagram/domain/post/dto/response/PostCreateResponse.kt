package com.numble.instagram.domain.post.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(value = SnakeCaseStrategy::class)
data class PostCreateResponse(
    val id: Long,
    val imageUrl: String?,
    val content: String,
)