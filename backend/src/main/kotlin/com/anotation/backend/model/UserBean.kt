package com.anotation.backend.model

import java.time.LocalDateTime
import java.util.UUID

data class UserBean(
    val userName: String,
    val userEmail: String,
    val userAge: Int
)

data class UserDetail(
    val uuid: UUID,
    val createAt: String,
    val environmentString: String,
    val profileDetailConfigString: String,
    val env1: String,
    val env2: String,
    val userBean: UserBean
)
