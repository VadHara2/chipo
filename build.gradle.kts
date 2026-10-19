import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    base
    alias(libs.plugins.kotlin.jpa) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
}

group = "com.vadhara7"
version = "0.0.1-SNAPSHOT"

subprojects {
    group = rootProject.group
    version = rootProject.version

    pluginManager.withPlugin("io.spring.dependency-management") {
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
    }
}
