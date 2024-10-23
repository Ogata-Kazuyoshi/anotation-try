package com.anotation.backend.component

import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

interface UserDetailComponent {
    fun createUUID(): UUID
    fun createCurrentDate(): String
}

@Component
class DefaultUserDetailComponent: UserDetailComponent{
    override fun createUUID(): UUID {
        return UUID.randomUUID()
    }

    override fun createCurrentDate(): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        return currentDateTime.format(formatter)
    }

}