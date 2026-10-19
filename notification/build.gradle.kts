plugins {
    alias(libs.plugins.chirp.spring.boot.service)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.amqp)
    implementation(libs.spring.boot.starter.mail)
    implementation(libs.firebase.admin.sdk)
    implementation(libs.okhttp.asProvider())
    implementation(libs.okhttp.logging)
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
