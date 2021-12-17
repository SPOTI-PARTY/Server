package io.github.spotiparty.server.domain.user.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User(

    @Id
    @Column(length = 60)
    val email: String

)