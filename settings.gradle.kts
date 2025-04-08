pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")

            // --------------------------------------------------------------
            // SDK 접근 설정
            // --------------------------------------------------------------
            credentials {
                username = "jp_ku9piga59cvtv8rlos3utncvms"
            }
            // --------------------------------------------------------------

        }
    }
}

rootProject.name = "appboxSample"
include(":app")
 