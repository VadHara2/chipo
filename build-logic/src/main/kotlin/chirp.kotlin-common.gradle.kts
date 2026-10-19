import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

configure<KotlinJvmProjectExtension> {
    jvmToolchain(21)

    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

val libraries = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    testImplementation(libraries.findLibrary("kotlin-test-junit5").get())
    testRuntimeOnly(libraries.findLibrary("junit-platform-launcher").get())
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
