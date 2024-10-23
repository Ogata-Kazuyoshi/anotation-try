package com.anotation.backend.service

import com.anotation.backend.component.UserDetailComponent
import com.anotation.backend.config.ProfilerDetailConfig
import com.anotation.backend.model.Environment
import com.anotation.backend.model.ProfilerDetail
import com.anotation.backend.model.UserBean
import com.anotation.backend.model.UserDetail
import com.anotation.backend.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDateTime
import java.util.*

@SpringBootTest
class DefaultUserServiceTest{
    @MockBean
    lateinit var userRepository: UserRepository
    @MockBean
    lateinit var userDetailComponent: UserDetailComponent
    @MockBean
    lateinit var profileChanger: ProfilerDetail
    @MockBean
    lateinit var environment: Environment
    @MockBean
    lateinit var createOtherProfiles: ProfilerDetailConfig

    lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
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
        `when`(userDetailComponent.createUUID()).thenReturn(expectedUUID)
        val expectedDateTime = LocalDateTime.of(2022,2,2,2,2,2).toString()
        `when`(userDetailComponent.createCurrentDate()).thenReturn(expectedDateTime)
        val expectedProfile = "test-local"
        `when`(profileChanger.profile).thenReturn(expectedProfile)
        val expectedProfileDetailString = "test-local1"
        `when`(createOtherProfiles.environmentString).thenReturn(expectedProfileDetailString)
        val expectedEnv1 = "test-env1"
        val expectedEnv2 = "test-env2"
        `when`(environment.env1).thenReturn(expectedEnv1)
        `when`(environment.env2).thenReturn(expectedEnv2)
        val expectedUserBean = UserBean(
            userName = "test-User",
            userEmail = "test@mail",
            userAge = 10
        )
        `when`(userRepository.getUserConfig1()).thenReturn(expectedUserBean)

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