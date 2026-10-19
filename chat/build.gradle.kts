plugins {
    alias(libs.plugins.chirp.kotlin.common)
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.websocket)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.redis)
    implementation(libs.kotlinx.coroutines.reactor)
    implementation(libs.kotlin.reflect)
}
