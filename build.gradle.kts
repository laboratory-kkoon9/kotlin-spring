plugins {
    val kotlinVersion = "1.8.21"
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    jacoco

}

object DependencyVersions {
    const val SPRINGDOC_VERSION = "2.0.4"
    const val KOTEST_VERSION = "5.5.5"
}

group = "com.laboratory-kkoon9"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // webflux
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:${DependencyVersions.SPRINGDOC_VERSION}")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

    // validator
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    implementation("org.slf4j:slf4j-api:2.0.5")

    // querydsl
    implementation ("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt ("com.querydsl:querydsl-apt:5.0.0:jakarta")

    // Testing tools
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:${DependencyVersions.KOTEST_VERSION}")
    testImplementation("io.kotest:kotest-assertions-core:${DependencyVersions.KOTEST_VERSION}")
    testImplementation("com.h2database:h2:1.4.200")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
    testImplementation("io.mockk:mockk:1.12.4")


    // DB
    implementation("mysql:mysql-connector-java")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    test {
        kotlin.srcDir("src/test/kotlin") // 테스트 코드를 src/test/kotlin 디렉토리에 작성하도록 변경
    }
}

kotlin {
    jvmToolchain(17)
}
