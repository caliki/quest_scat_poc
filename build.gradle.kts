// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("org.jetbrains.kotlinx.kover") version "0.8.0" apply true
    id("org.sonarqube") version "5.0.0.4638" apply true
}

sonarqube {
    properties {
        property("sonar.projectName", "quest_scat_poc")
        property("sonar.organization", "caliki")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.token", System.getenv("SONAR_TOKEN"))
        property("sonar.kotlin.coverage.reportPaths", "app/build/reports/kover/report.xml")
        property("sonar.androidLint.reportPaths","app/build/reports/lint-results-debug.xml")
    }
}