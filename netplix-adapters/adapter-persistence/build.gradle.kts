dependencies {
    implementation(project(":netplix-core:core-port")) //의존성 연결

    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // jpa
    implementation("org.springframework:spring-tx")

    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")

    runtimeOnly("com.mysql:mysql-connector-j")
}