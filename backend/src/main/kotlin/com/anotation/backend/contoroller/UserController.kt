package com.anotation.backend.contoroller

import com.anotation.backend.model.UserDetail
import com.anotation.backend.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    val userService: UserService
) {
    @GetMapping("/user1")
    fun getUser1(): UserDetail{
        return  userService.getUserConfig1()
    }
    @GetMapping("/user2")
    fun getUser2(): UserDetail{
        return  userService.getUserConfig2()
    }
}