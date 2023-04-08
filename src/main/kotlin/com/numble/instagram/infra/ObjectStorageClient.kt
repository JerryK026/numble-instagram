package com.numble.instagram.infra

import org.springframework.web.multipart.MultipartFile

interface ObjectStorageClient {
    fun upload(file: MultipartFile): String
    fun download(url: String): MultipartFile
}