plugins {
    alias(libs.plugins.chirp.spring.boot.service)
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.websocket)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.redis)
    implementation(libs.kotlinx.coroutines.reactor)
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
