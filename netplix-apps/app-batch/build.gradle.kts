dependencies {
    implementation(project(":netplix-core:core-usecase"))
    implementation(project(":netplix-core:core-domain"))
    implementation(project(":netplix-commons"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-batch")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // jpa
    implementation("org.springframework:spring-tx")

    runtimeOnly(project(":netplix-core:core-service"))
}

