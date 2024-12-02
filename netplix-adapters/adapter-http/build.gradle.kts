dependencies {
    implementation(project(":netplix-core:core-port")) //이렇게 하면 port에 있는 의존성을 받아올수 있다.
//    implementation(project(":netplix-core:core-domain")) //이렇게 하면 domain에 있는 sample의존성을 받아올수 있다
    implementation("org.springframework:spring-context")
}