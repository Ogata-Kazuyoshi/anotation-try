package com.anotation.backend.service

import com.anotation.backend.component.UserDetailComponent
import com.anotation.backend.config.ProfilerDetailConfig
import com.anotation.backend.model.Environment
import com.anotation.backend.model.ProfilerDetail
import com.anotation.backend.model.UserBean
import com.anotation.backend.model.UserDetail
import com.anotation.backend.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class DefaultUserServiceMockkTest{
    lateinit var userRepository: UserRepository
    lateinit var userDetailComponent: UserDetailComponent
    lateinit var profileChanger: ProfilerDetail
    lateinit var environment: Environment
    lateinit var createOtherProfiles: ProfilerDetailConfig

    lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        userRepository = mockk()
        userDetailComponent = mockk()
        profileChanger = mockk()
        environment = mockk()
        createOtherProfiles = mockk()
        userService = DefaultUserService(
            userRepository,
            userDetailComponent,
            profileChanger,
            environment,
            createOtherProfiles
        )
    }

    @Test
    fun getUserConfig1のテスト() {
        val expectedUUID = UUID.fromString("00000000-0000-0000-0000-000000000001")
        every { userDetailComponent.createUUID() } returns expectedUUID
        val expectedDateTime = LocalDateTime.of(2022,2,2,2,2,2).toString()
        every { userDetailComponent.createCurrentDate() } returns expectedDateTime
        val expectedProfile = "test-local"
        every { profileChanger.profile } returns expectedProfile
        val expectedProfileDetailString = "test-local1"
        every { createOtherProfiles.environmentString } returns expectedProfileDetailString
        val expectedEnv1 = "test-env1"
        val expectedEnv2 = "test-env2"
        every { environment.env1 } returns expectedEnv1
        every { environment.env2 } returns expectedEnv2
        val expectedUserBean = UserBean(
            userName = "test-User",
            userEmail = "test@mail",
            userAge = 10
        )
        every { userRepository.getUserConfig1() } returns expectedUserBean

        val result = userService.getUserConfig1()

        assertEquals(
            UserDetail(
                expectedUUID,
                expectedDateTime,
                expectedProfile,
                expectedProfileDetailString,
                expectedEnv1,
                expectedEnv2,
                expectedUserBean
            ),
            result
        )
    }
}