pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/release") }
        gradlePluginPortal()
    }
}

rootProject.name = "api"

include("core-service")
include("access-service")
