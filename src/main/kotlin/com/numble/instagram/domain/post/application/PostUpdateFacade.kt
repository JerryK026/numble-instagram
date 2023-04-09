package com.numble.instagram.domain.post.application

import com.numble.instagram.infra.ObjectStorageClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PostUpdateFacade @Autowired constructor(
    private val postService: PostService,
    private val objectStorageClient: ObjectStorageClient,
    ) {

}