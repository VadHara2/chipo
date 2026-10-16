import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    base
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.jpa) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
}

group = "com.vadhara7"
version = "0.0.1-SNAPSHOT"

subprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }

    apply(plugin = "io.spring.dependency-management")

    // Align dependency families in every module, including transitive artifacts.
    extra["kotlin.version"] = rootProject.libs.versions.kotlin.get()
    extra["kotlin-coroutines.version"] = rootProject.libs.versions.kotlinx.coroutines.get()
    extra["jackson-2-bom.version"] = rootProject.libs.versions.jackson.get()
    extra["jackson-bom.version"] = rootProject.libs.versions.jackson3.get()

    extensions.configure<DependencyManagementExtension> {
        imports {
            mavenBom(SpringBootPlugin.BOM_COORDINATES)
        }
    }

    pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
        extensions.configure<JavaPluginExtension> {
            toolchain {
                languageVersion = JavaLanguageVersion.of(21)
            }
        }

        extensions.configure<KotlinJvmProjectExtension> {
            jvmToolchain(21)
        }

        dependencies {
            "testImplementation"(rootProject.libs.kotlin.test.junit5)
            "testRuntimeOnly"(rootProject.libs.junit.platform.launcher)
        }

        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }
}
