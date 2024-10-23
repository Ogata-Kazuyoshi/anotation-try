package com.anotation.backend.config

import com.anotation.backend.model.Environment
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

class EnvironmentConfigTest{
    @Test
    fun getLocalEnvironment() {
        val environmentConfig = EnvironmentConfig()
        val testEnvironment = Environment(
            env1 = "test1",
            env2 = "test2"
        )

        val result = environmentConfig.getLocalEnvironment(
            environment1 = testEnvironment.env1,
            environment2 = testEnvironment.env2
        )

        assertEquals(testEnvironment.env1, result.env1)
        assertEquals(testEnvironment.env2, result.env2)
    }
}