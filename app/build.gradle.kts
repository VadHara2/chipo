plugins {
    alias(libs.plugins.chirp.kotlin.common)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(project(":common"))
    implementation(project(":user"))
    implementation(project(":chat"))
    implementation(project(":notification"))
    implementation(libs.spring.boot.starter.asProvider())
    implementation(libs.spring.boot.autoconfigure)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.thymeleaf)
    implementation(libs.thymeleaf.extras.springsecurity6)
    implementation(libs.jackson3.module.kotlin)
    implementation(libs.kotlin.reflect)

    annotationProcessor(libs.spring.boot.processor)

    developmentOnly(libs.spring.boot.devtools)

    runtimeOnly(libs.postgresql)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.spring.rabbit.test)
    testImplementation(libs.spring.restdocs.mockmvc)
    testImplementation(libs.spring.security.test)
    testImplementation(libs.spring.boot.test.actuator)
    testImplementation(libs.spring.boot.test.amqp)
    testImplementation(libs.spring.boot.test.data.jpa)
    testImplementation(libs.spring.boot.test.data.redis)
    testImplementation(libs.spring.boot.test.mail)
    testImplementation(libs.spring.boot.test.security)
    testImplementation(libs.spring.boot.test.thymeleaf)
    testImplementation(libs.spring.boot.test.validation)
    testImplementation(libs.spring.boot.test.webmvc)
    testImplementation(libs.spring.boot.test.websocket)

    testRuntimeOnly(libs.h2)
}
