package io.github.spotiparty.server.domain.user.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User(
    @Id
    val email: String
)