plugins {
    alias(libs.plugins.chirp.spring.boot.service)
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.crypto)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.jwt.api)
    implementation(libs.jackson.module.kotlin)

    compileOnly(libs.jakarta.servlet.api)

    runtimeOnly(libs.jwt.impl)
    runtimeOnly(libs.jwt.jackson)
}

tasks.bootJar {
    enabled = false
}

tasks.bootRun {
    enabled = false
}

tasks.jar {
    archiveClassifier = ""
}
