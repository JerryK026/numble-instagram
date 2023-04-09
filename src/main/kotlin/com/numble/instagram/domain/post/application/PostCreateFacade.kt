package com.numble.instagram.domain.post.application

import com.numble.instagram.domain.post.dto.request.PostCreateRequest
import com.numble.instagram.domain.post.dto.request.PostUpdateRequest
import com.numble.instagram.domain.post.dto.response.PostCreateResponse
import com.numble.instagram.infra.ObjectStorageClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class PostCreateFacade @Autowired constructor(
    private val postService: PostService,
    private val objectStorageClient: ObjectStorageClient,
) {
    fun create(content: String, image: MultipartFile?): PostCreateResponse {
        var url: String? = null
        if (image != null) {
            url = objectStorageClient.upload(image)
        }

        return postService.savePost(PostCreateRequest(content, url))
    }

    fun update(id: Long, content: String?, image: MultipartFile?): PostCreateResponse {
        var url: String? = null
        if (image != null) {
            url = objectStorageClient.upload(image)
        }

        return postService.updatePost(PostUpdateRequest(id, content, url))
    }
}