package com.numble.instagram.domain.post.application

import com.numble.instagram.domain.post.dao.PostRepository
import com.numble.instagram.domain.post.dto.request.PostCreateRequest
import com.numble.instagram.domain.post.dto.response.PostCreateResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
) {

    fun savePost(request: PostCreateRequest): PostCreateResponse {
        val post = postRepository.save(request.toEntity())
        return PostCreateResponse(post.id!!, post.imageUrl, post.content)
    }
}