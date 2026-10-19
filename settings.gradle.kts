pluginManagement {
    includeBuild("build-logic")
}

rootProject.name = "chirp"

include("app", "common", "user", "chat", "notification")
