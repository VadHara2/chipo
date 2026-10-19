import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("chirp.kotlin-common")
    id("org.springframework.boot")
}

val libraries = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libraries.findLibrary("kotlin-reflect").get())
    implementation(libraries.findLibrary("kotlin-stdlib").get())
    implementation(libraries.findLibrary("spring-boot-starter-web").get())

    testImplementation(libraries.findLibrary("spring-boot-starter-test").get())
}
