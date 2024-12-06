dependencies {
    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")

    implementation(project(":netplix-core:core-usecase")) //이렇게 하면 usecase를 참조 할수 있다
    implementation(project(":netplix-core:core-port"))//이렇게 하면 port를 참조 할수 있다
    implementation(project(":netplix-commons"))
    implementation(project(":netplix-core:core-domain"))


    runtimeOnly(project(":netplix-adapters:adapter-http"))
    runtimeOnly(project(":netplix-adapters:adapter-persistence"))
    runtimeOnly(project(":netplix-adapters:adapter-redis"))

    implementation("io.jsonwebtoken:jjwt-api")
    implementation("io.jsonwebtoken:jjwt-impl")
    implementation("io.jsonwebtoken:jjwt-jackson")


}