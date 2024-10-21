package com.anotation.backend.service

import com.anotation.backend.model.UserBean
import com.anotation.backend.repository.UserRepository
import org.springframework.stereotype.Service

interface UserService {
    fun getUserConfig1(): UserBean
    fun getUserConfig2(): UserBean
}

@Service
class DefaultUserService(
    val userRepository: UserRepository
): UserService{
    override fun getUserConfig1(): UserBean {
        return userRepository.getUserConfig1()
    }

    override fun getUserConfig2(): UserBean {
        return userRepository.getUserConfig2()
    }

}