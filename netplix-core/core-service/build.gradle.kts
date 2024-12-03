dependencies {
    implementation("org.springframework:spring-context")

    implementation(project(":netplix-core:core-usecase")) //이렇게 하면 usecase를 참조 할수 있다
    implementation(project(":netplix-core:core-port"))//이렇게 하면 port를 참조 할수 있다

    runtimeOnly(project(":netplix-adapters:adapter-http"))
    runtimeOnly(project(":netplix-adapters:adapter-persistence"))
}