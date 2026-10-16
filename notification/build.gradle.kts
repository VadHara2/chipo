plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.amqp)
    implementation(libs.spring.boot.starter.mail)
    implementation(libs.firebase.admin.sdk)
    implementation(libs.okhttp.asProvider())
    implementation(libs.okhttp.logging)
    implementation(libs.kotlin.reflect)
}
