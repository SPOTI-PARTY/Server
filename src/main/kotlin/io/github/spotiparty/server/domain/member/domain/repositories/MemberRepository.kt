package io.github.spotiparty.server.domain.member.domain.repositories

import io.github.spotiparty.server.domain.member.domain.Member
import org.springframework.data.repository.CrudRepository

interface MemberRepository: CrudRepository<Member, String> {
}