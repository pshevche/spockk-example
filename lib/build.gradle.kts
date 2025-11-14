plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spockk)
    alias(libs.plugins.kotlin.power.assert)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.spockk.core)
    testRuntimeOnly(libs.junit.platform.launcher)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
