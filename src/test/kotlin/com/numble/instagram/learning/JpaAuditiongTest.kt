package com.numble.instagram.learning

import com.numble.instagram.domain.member.entity.Member
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class JpaAuditiongTest @Autowired constructor(
    val em: EntityManager
) {


    @Test
    @DisplayName("Entity를 생성하면 updatedAt, createdAt이 자동으로 생성된다.")
    fun auditingTest() {
        // given
        val member = Member("soko", "")

        // when
        em.persist(member)
        em.flush()

        // then
        assertThat(member.createdAt).isNotNull()
        assertThat(member.updatedAt).isNotNull()
    }
}