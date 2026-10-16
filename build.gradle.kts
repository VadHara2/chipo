plugins {
	java
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.kotlin.jpa)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
}

group = "com.vadhara7"
version = "0.0.1-SNAPSHOT"

// Align each dependency family, including transitive artifacts, with the catalog.
extra["kotlin.version"] = libs.versions.kotlin.get()
extra["kotlin-coroutines.version"] = libs.versions.kotlinx.coroutines.get()
extra["jackson-2-bom.version"] = libs.versions.jackson.get()
extra["jackson-bom.version"] = libs.versions.jackson3.get()

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

kotlin {
	jvmToolchain(21)
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.spring.boot.starter.asProvider())
	implementation(libs.spring.boot.starter.crypto)
	implementation(libs.spring.boot.autoconfigure)
	implementation(libs.jwt.api)
	implementation(libs.jackson.module.kotlin)
	implementation(libs.jackson3.module.kotlin)
	implementation(libs.kotlin.reflect)
	implementation(libs.kotlin.stdlib)
	implementation(libs.kotlinx.coroutines.reactor)
	implementation(libs.okhttp.asProvider())
	implementation(libs.okhttp.logging)
	implementation(libs.firebase.admin.sdk)
	implementation(libs.spring.boot.starter.actuator)
	implementation(libs.spring.boot.starter.amqp)
	implementation(libs.spring.boot.starter.data.jpa)
	implementation(libs.spring.boot.starter.redis)
	implementation(libs.spring.boot.starter.mail)
	implementation(libs.spring.boot.starter.security)
	implementation(libs.spring.boot.starter.thymeleaf)
	implementation(libs.spring.boot.starter.validation)
	implementation(libs.spring.boot.starter.web)
	implementation(libs.spring.boot.starter.websocket)
	implementation(libs.thymeleaf.extras.springsecurity6)

	compileOnly(libs.jakarta.servlet.api)

	annotationProcessor(libs.spring.boot.processor)

	developmentOnly(libs.spring.boot.devtools)

	runtimeOnly(libs.jwt.impl)
	runtimeOnly(libs.jwt.jackson)
	runtimeOnly(libs.postgresql)

	testImplementation(libs.spring.boot.starter.test)
	testImplementation(libs.kotlin.test.junit5)
	testImplementation(libs.spring.rabbit.test)
	testImplementation(libs.spring.restdocs.mockmvc)
	testImplementation(libs.spring.security.test)
	testImplementation(libs.spring.boot.test.actuator)
	testImplementation(libs.spring.boot.test.amqp)
	testImplementation(libs.spring.boot.test.data.jpa)
	testImplementation(libs.spring.boot.test.data.redis)
	testImplementation(libs.spring.boot.test.mail)
	testImplementation(libs.spring.boot.test.security)
	testImplementation(libs.spring.boot.test.thymeleaf)
	testImplementation(libs.spring.boot.test.validation)
	testImplementation(libs.spring.boot.test.webmvc)
	testImplementation(libs.spring.boot.test.websocket)

	testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
	useJUnitPlatform()
}
