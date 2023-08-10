import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "com.rutubishi"
version = "0.1-alpha"

kotlin {

    android {
        jvmToolchain(11)
    }

    jvm("desktop") {
        jvmToolchain(11)
    }

    @OptIn(ExperimentalComposeLibrary::class)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
                api(compose.materialIconsExtended)
                api(compose.preview)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(compose.uiTestJUnit4)
            }
        }

//        val jvmMain by getting
        val androidMain by getting {
            dependencies {
                api(libs.appcompat)
                api(libs.core.ktx)
                api(libs.bundles.dev)
            }
        }
        val desktopMain by getting
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}