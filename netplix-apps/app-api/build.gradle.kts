dependencies {
    implementation(project(":netplix-core:core-usecase"))

    runtimeOnly(project(":netplix-core:core-service"))//runtime 시점에 그모듈을 바라보게 한다.

    implementation("org.springframework.boot:spring-boot-starter-web")
}