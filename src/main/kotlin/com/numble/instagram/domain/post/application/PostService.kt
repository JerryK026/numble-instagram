package com.numble.instagram.domain.post.application

import com.numble.instagram.domain.post.dao.PostRepository
import com.numble.instagram.domain.post.dto.request.PostCreateRequest
import com.numble.instagram.domain.post.dto.request.PostUpdateRequest
import com.numble.instagram.domain.post.dto.response.PostCreateResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
) {

    @Transactional
    fun savePost(request: PostCreateRequest): PostCreateResponse {
        val post = postRepository.save(request.toEntity())
        return PostCreateResponse(post.id!!, post.imageUrl, post.content)
    }

    @Transactional
    fun updatePost(request: PostUpdateRequest): PostCreateResponse {
        val post = postRepository.findByIdOrNull(request.id) ?: throw IllegalArgumentException("존재하지 않는 게시물입니다.")
        post.update(request.content, request.imageUrl)
        return PostCreateResponse(post.id!!, post.imageUrl, post.content)
    }
}