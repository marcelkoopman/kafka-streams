plugins {
    application
    kotlin("jvm") version "1.3.40"
}

application {
    mainClassName = "main.kotlin.MainKt"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.apache.kafka:kafka-streams:2.3.0")
    compile("org.slf4j:slf4j-api:1.7.26")
    compile("org.apache.logging.log4j:log4j-slf4j-impl:2.11.2")

}

repositories {
    jcenter()
}