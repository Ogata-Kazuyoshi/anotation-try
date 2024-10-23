package com.anotation.backend.config

import com.anotation.backend.model.Environment
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EnvironmentConfig {

    @Bean
    fun getLocalEnvironment(
        @Value("\${local.environment1.value}")
        environment1: String,
        @Value("\${local.environment2.value}")
        environment2: String
    ): Environment{
        return Environment(
            env1 = environment1,
            env2 = environment2
        )
    }
}