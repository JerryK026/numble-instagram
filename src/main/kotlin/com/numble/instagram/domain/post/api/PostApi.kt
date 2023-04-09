package com.numble.instagram.domain.post.api

import com.numble.instagram.domain.post.application.PostCreateFacade
import com.numble.instagram.domain.post.application.PostService
import com.numble.instagram.domain.post.dto.request.PostUpdateRequest
import com.numble.instagram.domain.post.dto.response.PostCreateResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/posts")
class PostApi(
    private val postCreateFacade: PostCreateFacade,
    private val postService: PostService,
) {

    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun create(@RequestParam content: String, @RequestParam image: MultipartFile): ResponseEntity<PostCreateResponse> {
        return ResponseEntity(postCreateFacade.create(content, image), HttpStatus.OK)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody request: PostUpdateRequest, @RequestParam image: MultipartFile): ResponseEntity<PostCreateResponse> {
        return ResponseEntity(postCreateFacade.update(request.id, request.content, image), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        postService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}