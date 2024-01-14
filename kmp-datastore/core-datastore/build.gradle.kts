plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.googleProtobuf)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            api(project(":core-definitions"))
            api(libs.androidx.datastore.preferences.core)
            api(libs.androidx.datastore.core)
            api(libs.protobuf.kotlin)
        }
    }
}

android {
    namespace = "com.rutubishi.kmpdatastore"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
}

protobuf {
    // Configures the Protobuf compilation and the protoc executable
    protoc {
        // Downloads from the repositories
        artifact = "com.google.protobuf:protoc:3.14.0"
    }

    generateProtoTasks {
        all().forEach {task ->
            task.builtins {
            }
        }
    }

}