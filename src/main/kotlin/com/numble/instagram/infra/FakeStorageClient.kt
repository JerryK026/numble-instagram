package com.numble.instagram.infra

import com.numble.instagram.global.fakeMultipartFileUrlFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
/**
 * 실제로는 Object Storage 연결하지 않는 객체이기 때문에 필요 없지만 트랜잭션 분리를 명시하기 위해 추가
 * @author: JerryK026
 * @updated_at: 2021-04-26
 */
@Transactional
class FakeStorageClient : ObjectStorageClient {

    override fun upload(file: MultipartFile): String {
        return fakeMultipartFileUrlFactory(file.name)
    }

    override fun download(url: String): MultipartFile {
        return FakeMultipartFile(url.encodeToByteArray(), url)
    }

}