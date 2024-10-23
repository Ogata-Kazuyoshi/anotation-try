package com.anotation.backend.service

import com.anotation.backend.component.UserDetailComponent
import com.anotation.backend.config.ProfilerDetailConfig
import com.anotation.backend.config.ProfilesChanger
import com.anotation.backend.model.Environment
import com.anotation.backend.model.ProfilerDetail
import com.anotation.backend.model.UserBean
import com.anotation.backend.model.UserDetail
import com.anotation.backend.repository.UserRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

interface UserService {
    fun getUserConfig1(): UserDetail
    fun getUserConfig2(): UserDetail
}

@Service
class DefaultUserService(
    val userRepository: UserRepository,
    val userDetailComponent: UserDetailComponent,
    val profileChanger: ProfilerDetail,
    val environment: Environment,
    val createOtherProfiles: ProfilerDetailConfig
): UserService{
    override fun getUserConfig1(): UserDetail {
        return UserDetail(
            uuid = userDetailComponent.createUUID(),
            createAt = userDetailComponent.createCurrentDate(),
            environmentString = profileChanger.profile,
            profileDetailConfigString = createOtherProfiles.environmentString,
            env1 = environment.env1,
            env2 = environment.env2,
            userBean = userRepository.getUserConfig1()
        )
    }

    override fun getUserConfig2(): UserDetail {
        return UserDetail(
            uuid = userDetailComponent.createUUID(),
            createAt = userDetailComponent.createCurrentDate(),
            environmentString = profileChanger.profile,
            profileDetailConfigString = createOtherProfiles.environmentString,
            env1 = environment.env1,
            env2 = environment.env2,
            userBean = userRepository.getUserConfig2()
        )
    }

}