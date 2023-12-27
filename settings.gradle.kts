pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FoolStack"
include(":app")
include(":features:splash")
include(":features:auth")
include(":features:tech")
include(":features:screening")
include(":features:tests")
include(":features:profile")
include(":features:settings")
include(":features:authorized")
include(":features:guest")
include(":base:storage")
include(":base:network")
include(":base:network:api")
include(":base:network:data")
include(":base:navigation")
include(":base:viewModel")
include(":base:utils")
include(":base:ui")
include(":base:local")


