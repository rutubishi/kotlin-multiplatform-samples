plugins {
    kotlin("multiplatform")
    id("io.ktor.plugin") version "2.3.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(libs.bundles.ktor.server)
                api(libs.bundles.shared)
             }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.ktor.server.tests)
                implementation(libs.koin.test.junit5)
            }
        }
    }
}

group = "com.rutubishi"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}



