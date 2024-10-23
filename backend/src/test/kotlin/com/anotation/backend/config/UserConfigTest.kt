package com.anotation.backend.config

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class UserConfigTest{
    lateinit var userConfig: UserConfig

    @BeforeEach
    fun setUp() {
        userConfig = UserConfig()
    }

    @Test
    fun userBean1のテスト() {
        val result = userConfig.userBean1()

        assertEquals("userBean1",result.userName)
        assertEquals("hogehoge.com",result.userEmail)
        assertEquals(10,result.userAge)
    }

    @Test
    fun userBean2のテスト() {
        val result = userConfig.userBean2()

        assertEquals("userBean2",result.userName)
        assertEquals("fugafuga.com",result.userEmail)
        assertEquals(20,result.userAge)
    }
}