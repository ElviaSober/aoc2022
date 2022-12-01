plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.6.21"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.0.1-jre")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            useKotlinTest()
        }
        dependencies {
            implementation("com.willowtreeapps.assertk:assertk:0.25")
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("aocskeleton.AppKt")
}

tasks.named<JavaExec>("run") {
//    Connect the System.in of the gradle build with the System.in of the run task
    standardInput = System.`in`
}