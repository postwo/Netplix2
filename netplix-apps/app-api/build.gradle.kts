dependencies {
    implementation(project(":netplix-core:core-usecase"))
    implementation(project(":netplix-commons"))

    runtimeOnly(project(":netplix-core:core-service"))//runtime 시점에 그모듈을 바라보게 한다.

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client") //지금은 실행할려면 에러가 뜨기 때문에 주석처리
    implementation("org.springframework.security:spring-security-oauth2-client")
    implementation("org.springframework.data:spring-data-commons")

}

// api 모듈은 boot jar이름을 알아야 해서 추가
val appMainClassName = "fast.campus.netplix.NetplixApiApplication"
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    mainClass.set(appMainClassName)
    archiveClassifier.set("boot")
}