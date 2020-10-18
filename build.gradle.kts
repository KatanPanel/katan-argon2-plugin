import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "me.devnatan.katan.plugin.argon2"
version = "0.1.0"

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("com.github.KatanPanel:Katan:1606e48e9e") // 0.0.1
    implementation("de.mkammerer:argon2-jvm:2.7")
}

val fatJar = task("fatJar", type = Jar::class) {
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
            jvmTarget = "1.8"
        }
    }

    withType<Jar> {
        manifest {
            attributes["Implementation-Version"] = archiveVersion
        }
        archiveBaseName.set("${project.name}-all")
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
}