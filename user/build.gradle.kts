plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.crypto)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.jwt.api)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.kotlin.reflect)

    compileOnly(libs.jakarta.servlet.api)

    runtimeOnly(libs.jwt.impl)
    runtimeOnly(libs.jwt.jackson)
}
