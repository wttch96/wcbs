import com.wttch.plugin.libs.dependencies.Spring
import com.wttch.plugin.libs.dependencies.Jackson

dependencies {
    api(project(":core"))

    api(project(":common:mybatis-autoconfigure"))
//    api(project(":data:data-jdbc"))
    api(Spring.Boot.starterAop)
    implementation(Jackson.annotations)

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}
