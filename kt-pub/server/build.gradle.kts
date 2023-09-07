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
                implementation("io.ktor:ktor-server-core-jvm:2.3.4")
                implementation("io.ktor:ktor-server-auth-jvm:2.3.4")
                implementation("io.ktor:ktor-server-auth-jwt-jvm:2.3.4")
                implementation("io.ktor:ktor-server-host-common-jvm:2.3.4")
                implementation("io.ktor:ktor-server-status-pages-jvm:2.3.4")
                implementation("io.ktor:ktor-server-cors-jvm:2.3.4")
                implementation("io.ktor:ktor-server-swagger-jvm:2.3.4")
                implementation("io.ktor:ktor-server-openapi:2.3.4")
                implementation("io.ktor:ktor-server-content-negotiation-jvm:2.3.4")
                implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.4")
                implementation("io.ktor:ktor-server-netty-jvm:2.3.4")
                implementation("ch.qos.logback:logback-classic:1.4.11")
                implementation("io.ktor:ktor-server-config-yaml:2.3.4")
             }
        }
        val jvmTest by getting {
            dependencies {
                implementation("io.ktor:ktor-server-tests-jvm:2.3.4")
                implementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.0")
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



