package com.anotation.backend.repository

import com.anotation.backend.model.UserBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

interface UserRepository {
    fun getUserConfig1(): UserBean
    fun getUserConfig2(): UserBean
}

@Repository
class DefaultUserRepository(
    @Qualifier("userBean1")
    val userBeanConfig1: UserBean,
    @Qualifier("userBean2")
    val userBeanConfig2: UserBean
):UserRepository {
    override fun getUserConfig1(): UserBean {
        return userBeanConfig1
    }

    override fun getUserConfig2(): UserBean {
        return userBeanConfig2
    }

}