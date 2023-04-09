package com.numble.instagram.post.service

import com.numble.instagram.domain.post.application.PostService
import com.numble.instagram.domain.post.domain.Post
import com.numble.instagram.domain.post.dao.PostRepository
import com.numble.instagram.domain.post.dto.request.PostUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class PostServiceTest @Autowired constructor(
    private val postService: PostService,
    private val postRepository: PostRepository,
) {

    @Test
    @DisplayName("게시물을 저장에 성공한다")
    fun savePostTest() {
        // given
        postRepository.save(Post("content", "imageUrl"))

        // when & then
        val posts = postRepository.findAll()
        assertThat(posts).hasSize(1)
        assertThat(posts[0].content).isEqualTo("content")
        assertThat(posts[0].imageUrl).isEqualTo("imageUrl")
    }

    @Test
    @DisplayName("게시물을 수정에 성공한다")
    fun editPostTest() {
        // given
        val post = postRepository.save(Post("content", "imageUrl"))
        val response = postService.updatePost(PostUpdateRequest(post.id!!, "newContent", "newImageUrl"))

        // when & then
        val foundPost: Post? = postRepository.findByIdOrNull(response.id)
        assertThat(foundPost?.content).isEqualTo("newContent")
        assertThat(foundPost?.imageUrl).isEqualTo("newImageUrl")
    }
}