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

val localProperties = java.util.Properties()
val localPropertiesFile = File(rootDir, "local.properties")

if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { localProperties.load(it) }
}

val gprUser: String = localProperties.getProperty("gpr.user") ?: ""
val gprKey: String = localProperties.getProperty("gpr.key") ?: ""

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // appbox-auth-kakao 를 사용할 때만 필요합니다.
        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") }

        // --------------------------------------------------------------
        // SDK 접근 설정
        // --------------------------------------------------------------
        maven {
            url = uri("https://maven.pkg.github.com/MobilePartnersCo/AppBoxSDKPackage")
            credentials {
                username = gprUser
                password = gprKey
            }
        }
    }
}

rootProject.name = "appboxSample"
include(":app")
 