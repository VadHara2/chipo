# Chirp

A modular monolith built with Kotlin, Spring Boot, and Java 21.

Project documentation is maintained in English.

## Modules

```text
app ──────────┬── user ─────────┐
              ├── chat ─────────┤
              ├── notification ┤── common
              └────────────────┘
```

- `app` — application entry point, configuration, and integration tests. The only module that produces an executable Spring Boot JAR.
- `user` — reserved for user management and authentication.
- `chat` — reserved for chat functionality and WebSocket communication.
- `notification` — reserved for notifications and integrations with AMQP, email, and Firebase.
- `common` — shared Kotlin types and utilities, with no dependencies on Spring or other modules.

`app` depends on all other modules. `user`, `chat`, and `notification` depend only on `common` and their external libraries. Feature modules do not depend directly on one another.

## Feature module layers

Each of `user`, `chat`, and `notification` contains the following packages under `com.vadhara7.chirp.<module>`:

- `api` — controllers, DTOs, and external contracts; calls `service`.
- `service` — application use cases; uses types and interfaces from `domain`.
- `domain` — business models, rules, and interfaces for accessing external systems. Does not depend on Spring, JPA, or other layers.
- `infra` — implementations of domain interfaces, persistence models, and external integrations.

These layers are packages within Gradle modules, so their boundaries are a code organization convention and are not enforced by the compiler. Keep shared concepts in `common` and feature-specific business logic in the corresponding feature module.

The packages are currently empty and tracked using `.gitkeep`. Business functionality, custom HTTP endpoints, and database entities have not been implemented yet.

## Build and test

JDK 21 is required. The Gradle Wrapper is included in the repository.

```sh
./gradlew projects
./gradlew clean build :app:bootJar
```

`ChirpApplicationTests` starts the Spring context with the `test` profile and an in-memory H2 database. H2 is available only during testing and is not included in the executable JAR. This test does not require external PostgreSQL, RabbitMQ, or Redis instances, or Firebase credentials.

Library versions are defined in `gradle/libs.versions.toml`. The root build aligns Kotlin, Coroutines, and Jackson versions through the Spring Boot BOM across all modules. Jackson 2 is used for JJWT, while Jackson 3 handles HTTP JSON in Spring Boot.

## Run

Running the application requires PostgreSQL. Provide your database connection settings through environment variables:

```sh
export SPRING_DATASOURCE_URL='jdbc:postgresql://localhost:5432/chirp'
export SPRING_DATASOURCE_USERNAME='chirp'
export SPRING_DATASOURCE_PASSWORD='<your-password>'
./gradlew :app:bootRun
```

Alternatively, after building, run `java -jar app/build/libs/app-0.0.1-SNAPSHOT.jar` with the same environment variables. The H2 test configuration does not replace the PostgreSQL connection used when running the application.
