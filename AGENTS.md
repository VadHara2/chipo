# Project instructions

Read `README.md` for the architecture, setup, and run commands.

## Conventions

- Write application code in Kotlin and use JDK 21.
- Maintain project documentation in English.
- Define dependency versions in `gradle/libs.versions.toml`; preserve the shared BOM alignment in the root build.

## Architecture

- `app` is the composition root and the only executable Spring Boot module.
- `app` depends on `common`, `user`, `chat`, and `notification`.
- Feature modules depend on `common`, not directly on one another.
- Keep shared types and utilities in `common`, without Spring dependencies or feature-specific business logic.
- Each feature module has `api`, `service`, `domain`, and `infra` packages.
- `api` calls `service`; `service` uses domain types and interfaces; `infra` implements domain interfaces.
- Keep `domain` independent of Spring, JPA, and the other layers.

## Validation

- After code or Gradle changes, run `./gradlew build :app:bootJar` with JDK 21.
- Keep H2 and its configuration limited to tests; normal application runs use PostgreSQL.
- The Spring context test must run without external services or Firebase credentials.
- Report any failed checks or checks that could not be run.
