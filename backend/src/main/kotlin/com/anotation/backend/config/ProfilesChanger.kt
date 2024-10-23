package com.anotation.backend.config

import com.anotation.backend.model.ProfilerDetail
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class ProfilesChanger {
    @Bean
    @Profile("local")
    fun createLocalProfilers(): ProfilerDetailConfig{
        return ProfilerDetailConfig("localProfiler")
    }

    @Bean
    @Profile("!local")
    fun createOtherProfiles(): ProfilerDetailConfig{
        return ProfilerDetailConfig("otherProfiler")
    }

    @Bean
    fun getProfilers(
        profilerDetail: ProfilerDetailConfig
    ): ProfilerDetail{
        return ProfilerDetail(
            profile = profilerDetail.environmentString
        )
    }
}

data class ProfilerDetailConfig(
    val environmentString: String
)