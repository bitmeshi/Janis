plugins {
    id("java-library")
    id("maven-publish")
}

group = "com.github.bitmeshi"
version = "1.0.0"

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "Janis"
            groupId = project.group.toString()
        }
    }
}

tasks.test {
    useJUnitPlatform()
}