package com.anotation.backend.config

import com.anotation.backend.model.UserBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserConfig {
    @Bean
    fun userBean1(): UserBean{
        return UserBean(
            userName = "userBean1",
            userEmail = "hogehoge.com",
            userAge = 10
        )
    }

    @Bean
    fun userBean2(): UserBean{
        return UserBean(
            userName = "userBean2",
            userEmail = "fugafuga.com",
            userAge = 20
        )
    }
}