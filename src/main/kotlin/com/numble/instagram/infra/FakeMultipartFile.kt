package com.numble.instagram.infra

import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import java.lang.IllegalArgumentException

class FakeMultipartFile(
    private val input: ByteArray,
    private val name: String
) : MultipartFile {
    override fun getInputStream(): InputStream {
        return ByteArrayInputStream(input);
    }

    override fun getName(): String {
        return name
    }

    override fun getOriginalFilename(): String? {
        return name
    }

    override fun getContentType(): String? {
        return "image/jpeg"
    }

    override fun isEmpty(): Boolean {
        return input.isEmpty()
    }

    override fun getSize(): Long {
        return input.size.toLong()
    }

    override fun getBytes(): ByteArray {
        return input
    }

    override fun transferTo(dest: File) {
        IllegalArgumentException("Not implemented")
    }
}