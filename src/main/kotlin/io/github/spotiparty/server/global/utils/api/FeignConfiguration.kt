package io.github.spotiparty.server.global.utils.api

import feign.Logger
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@EnableFeignClients(basePackages = ["io.github.spotiparty.server.global.utils.api"])
@Import(FeignClientErrorDecoder::class)
@Configuration
class FeignConfiguration {

    @Bean
    fun feignLoggerLevel(): Logger.Level = Logger.Level.BASIC

    @Bean
    @ConditionalOnMissingBean(value = [ErrorDecoder::class])
    fun commonFeignErrorDecoder() = FeignClientErrorDecoder()

}