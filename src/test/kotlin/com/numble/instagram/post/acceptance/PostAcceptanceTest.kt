package com.numble.instagram.post.acceptance

import com.numble.instagram.domain.post.application.PostCreateFacade
import com.numble.instagram.global.fakeMultipartFileUrlFactory
import com.numble.instagram.infra.FakeMultipartFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PostAcceptanceTest @Autowired constructor(
    private val postCreateFacade: PostCreateFacade,
) {

    @Test
    @DisplayName("게시물을 저장에 성공한다")
    fun postCreate() {
        // given
        val FILENAME = "fileName"
        val CONTENT = "content"

        // when
        val response = postCreateFacade.create(
            CONTENT,
            FakeMultipartFile(FILENAME.toByteArray(), FILENAME)
        )

        // then
        assertThat(response.id).isNotNull()
        assertThat(response.content).isEqualTo(CONTENT)
        assertThat(response.imageUrl).isEqualTo(fakeMultipartFileUrlFactory(FILENAME))
    }
}